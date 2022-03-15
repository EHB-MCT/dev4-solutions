package com.ehb.demo_1

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}

@RestController
class MessageResource(){

    @GetMapping
    fun index(): String {
        return "Check!"
    }
    @GetMapping("message")
    fun getMessage(): Message{
        return Message(1, "Our first message!");
    }
    @GetMapping("messages")
    fun getListOfMessage(): List<Message>{
        return listOf(
            Message(2, "Test again"),
            Message(3, "Test again again"),
            Message(4, "Test again again again"),
        )
    }
}


data class Message(val id: Long, val text: String)
