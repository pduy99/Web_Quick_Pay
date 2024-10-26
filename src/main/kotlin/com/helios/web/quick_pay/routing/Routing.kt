package com.helios.web.quick_pay.routing

import io.ktor.resources.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*

@Resource("/")
class Index

fun Application.configureRouting() {
    routing {
        styles()
        index()
        staticResources("/static", "static")
    }
}