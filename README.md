# Ktor Payment QR Server

A Kotlin Multiplatform (KMP) web server that simplifies bank transfers by displaying payment QR codes. Users can either scan the QR code with their banking app or tap it to automatically open their banking app with pre-filled payment details. Built with KMP, this solution works across multiple platforms and provides a seamless payment experience.

## ✨ Features

- **QR Code Display**: Clean, responsive interface for displaying payment QR codes.
- **Quick Payment**: One-tap solution to open banking apps with pre-filled payment details.
- **Cross-Platform**: Works seamlessly across desktop and mobile devices.
- **Responsive Design**: Optimized layout for various screen sizes.

## 🛠️ Tech Stack

- **[Kotlin](https://github.com/JetBrains/kotlin)**: Modern, concise programming language.
- **[Ktor](https://github.com/ktorio/ktor)**: Lightweight web framework for Kotlin.
- **[FreeMarker](https://ktor.io/docs/server-freemarker.html)**: Template engine for dynamic content.
- **[Ktor Resources](https://ktor.io/docs/server-resources.html)**: Type-safe routing plugin.

## 🚀 Getting Started

### Prerequisites

- Java 11 or higher
- Gradle (included in wrapper)

### Installation

1. Clone the repository.

2. Replace QR code images:
   - Navigate to `src/main/resources/static/`
   - Replace existing QR images with your own

### Running the Server

1. Start the server using Gradle:
   ```bash
   ./gradlew run
   ```

2. Access the application:
   - Open your browser
   - Navigate to [http://localhost:8080/](http://localhost:8080/)
   - Default port is 8080 (configurable in application.yaml)

## 📱 Screenshots

### Desktop View
![Desktop Screenshot](screenshots/screenshot_web.png)

### Mobile View
![Mobile Screenshot](screenshots/screenshot_mobile.jpg)

## 🔧 Configuration

### Port Configuration
To change the default host and port (8080), modify `application.yaml`:

```yaml
ktor:
  application:
    modules:
      - com.helios.web.quick_pay.ApplicationKt.main
  deployment:
    port: 8080
    host: 0.0.0.0

```

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
