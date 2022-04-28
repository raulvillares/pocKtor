package com.example

import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*


fun Application.static() {
    routing {
        routing {
            static("/") {
                staticBasePackage = "assets"
                resource("index.html")
                defaultResource("index.html")
                static("images") {
                    resource("img/exeal.jpeg")
                    resource("logo.png", "img/zooplus.jpeg")
                }
            }
        }
    }
}