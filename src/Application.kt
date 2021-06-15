package com.sdzsn3

import com.google.gson.Gson
import com.sdzsn3.routes.createRoomRoute
import com.sdzsn3.routes.getRoomsRoute
import com.sdzsn3.routes.joinRoomRoute
import com.sdzsn3.session.DrawingSession
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.gson.*
import io.ktor.features.*
import org.slf4j.event.*
import io.ktor.websocket.*
import io.ktor.http.cio.websocket.*
import io.ktor.sessions.*
import io.ktor.util.*
import java.time.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

val server = DrawingServer()
val gson = Gson()

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(Sessions) {
        cookie<DrawingSession>("SESSION")
    }
    intercept(ApplicationCallPipeline.Features) {
        if (call.sessions.get<DrawingSession>() == null) {
            val clientId = call.parameters["client_id"] ?: ""
            call.sessions.set(DrawingSession(clientId, generateNonce()))
        }
    }
    install(WebSockets)
    install(Routing) {
        createRoomRoute()
        getRoomsRoute()
        joinRoomRoute()
    }
    install(ContentNegotiation) {
        gson {

        }
    }

    install(CallLogging)

}

