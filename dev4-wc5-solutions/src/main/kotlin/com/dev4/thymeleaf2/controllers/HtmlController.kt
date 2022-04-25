package com.dev4.thymeleaf2.controllers

import com.dev4.thymeleaf2.models.CreateMessage
import com.dev4.thymeleaf2.services.MessageService
import com.dev4.thymeleaf2.models.Message
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Controller
class HtmlController() {
    @Autowired
    lateinit var messageService: MessageService

    @GetMapping("/")
    fun index(model: Model): String {
        model.addAttribute("name", "Joni")
        return "index"
    }

    @GetMapping("/messages")
    fun listMessages(model: Model): String {
        model.addAttribute("messages", messageService.getMessages())
        //Add an model to the form that will be used by the form
        model.addAttribute("createMessage", CreateMessage())
        return "messages"
    }

   @PostMapping("/addMessage")
    fun addMessage(@ModelAttribute("createMessage") createMessage: CreateMessage, model: Model): String {
        println(createMessage.author)
        println(createMessage.message)
        messageService.addMessage(Message(createMessage.author!!, createMessage.message!! ))
        return "redirect:/messages"
    }


}