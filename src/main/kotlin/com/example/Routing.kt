package com.example

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.routingApp() {
    routing {
        get("/") {
            call.respondText("Routing Demo")
        }
        route("shop") {
            get {
                call.respondText(call.request.queryParameters["id"].toString())
            }
            post {
                call.respondText("Performed a POST")
            }
        }
        route("customer") {
            get("{id}") {
                call.respondText(call.parameters["id"].toString())
            }
        }
        route("order") {
            route("delivered") {
                get {
                    call.respondText("Orders delivered")
                }
            }
            route("undelivered") {
                get {
                    call.respondText("Orders undelivered")
                }
            }
        }
    }
}