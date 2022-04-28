package com.example

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Route.home() {
    get("/") {
        call.respondText("Welcome!")
    }
    get("/about") {
        call.respondText("Just checking Ktor out")
    }
}


fun Route.legal() {

    route("/notice") {
        get {
            call.respondText("Nothing illegal here")
        }
    }

    route("/cookies") {
        get {
            call.respondText("We don't use cookies (right now)")
        }
    }

    route("/privacy") {
        get {
            call.respondText("Don't be evil")
        }
    }
}

fun Application.appStructure() {
    routing {
        home()
        legal()
    }

}