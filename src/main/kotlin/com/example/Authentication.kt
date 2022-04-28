package com.example

import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.authentication() {
    install(Authentication) {
        basic("auth") {
            realm = "Auth Sample"
            validate { credentials ->
                if (credentials.name == "raul" && credentials.password == "1234") {
                    UserIdPrincipal(credentials.name)
                } else {
                    null
                }
            }
        }
    }
    routing {
        get("/") {
            call.respondText("Allowed without credentials. Try /private")
        }
        authenticate("auth") {
            get("/private") {
                call.respondText("Accessed private area")
            }
        }
    }
}