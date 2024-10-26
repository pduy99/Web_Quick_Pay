package com.helios.web.quick_pay.routing

import io.ktor.server.freemarker.*
import io.ktor.server.resources.*
import io.ktor.server.routing.*

fun Route.index() {
    get<Index> {
        call.respond(
            FreeMarkerContent(
                template = "index.ftl",
                model = null,
            ),
            null
        )
    }
}