package com.helios.web.quick_pay

import com.helios.web.quick_pay.routing.configureRouting
import freemarker.cache.ClassTemplateLoader
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.plugins.calllogging.*
import io.ktor.server.plugins.conditionalheaders.*
import io.ktor.server.plugins.defaultheaders.*
import io.ktor.server.plugins.partialcontent.*
import io.ktor.server.resources.*

fun Application.main() {
    // This adds the Date and Server headers to each response and would allow you to configure
    // additional headers served to each response.
    install(DefaultHeaders)
    // This uses the logger to log every call (request/response)
    install(CallLogging)
    // Automatic '304 Not Modified' Responses
    install(ConditionalHeaders)
    // Supports for Range, Accept-Range and Content-Range headers
    install(PartialContent)
    // Allows using classes annotated with @Resource to represent URLs.
    // They are typed, can be constructed to generate URLs, and can be used to register routes.
    install(Resources)
    // Adds support to generate templated responses using FreeMarker.
    // We configure it specifying the path inside the resources to use to get the template files.
    // You can use <!-- @ftlvariable --> to annotate types inside the templates
    // in a way that works with IntelliJ IDEA Ultimate.
    // You can check the `resources/templates/*.ftl` files for reference.
    install(FreeMarker) {
        templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates")
    }

    configureRouting()
}