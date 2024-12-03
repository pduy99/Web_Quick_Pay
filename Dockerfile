# Stage 1: Cache Gradle dependencies
FROM gradle:latest AS cache
RUN mkdir -p /home/gradle/cache_home
ENV GRADLE_USER_HOME /home/gradle/cache_home
COPY build.gradle.* gradle.properties* /home/gradle/app/
WORKDIR /home/gradle/app
RUN gradle clean build -i --stacktrace

# Stage 2: Build Application
FROM gradle:latest AS build
COPY --from=cache /home/gradle/cache_home /home/gradle/.gradle
COPY . /usr/src/app/
WORKDIR /usr/src/app
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
# Build the fat JAR, Gradle also supports shadow
# and boot JAR by default.
RUN gradle buildFatJar --no-daemon

# Stage 3: Generate a self-signed SSL certificate
ARG KEYSTORE_PASSWORD
ARG KEY_PASSWORD
RUN keytool -keystore /quick_pay_ktor_keystore.jks \
    -alias heliosAlias \
    -genkeypair \
    -keyalg RSA \
    -keysize 4096 \
    -validity 3 \
    -storepass ${KEYSTORE_PASSWORD} \
    -keypass ${KEY_PASSWORD} \
    -dname 'CN=localhost, OU=ktor, O=ktor, L=Unspecified, ST=Unspecified, C=US'

# Stage 4: Create the Runtime Image
FROM amazoncorretto:22 AS runtime
EXPOSE 8443:8443
RUN mkdir /app
COPY --from=build /quick_pay_ktor_keystore.jks /./quick_pay_ktor_keystore.jks
COPY --from=build /home/gradle/src/build/libs/*.jar /app/ktor-docker-sample.jar
ENTRYPOINT ["java","-jar","/app/ktor-docker-sample.jar"]