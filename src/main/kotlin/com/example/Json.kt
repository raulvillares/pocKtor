package com.example

import io.ktor.server.application.*
import io.ktor.server.plugins.ContentNegotiation
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

@Serializable
data class Person(val name: String, val age: Int)

fun Application.json() {

    install(ContentNegotiation) {
        json()
    }
    routing {
        get("/person") {
            val person = Person("Raul", 40)
            call.respond(person)
        }
    }
}