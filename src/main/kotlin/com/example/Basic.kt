package com.example

import io.ktor.server.application.*
import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Application.basic() {
    routing {
        get("/") {
            call.respondText("Hello Ktor!", ContentType.Text.Plain)
        }
    }
}