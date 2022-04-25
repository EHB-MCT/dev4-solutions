package com.dev4.thymeleaf2.services

import com.dev4.thymeleaf2.models.Message
import com.dev4.thymeleaf2.repositories.MessageRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MessageService() {

    @Autowired
    lateinit var repository: MessageRepository

    fun getMessages(): List<Message> {
        return repository.findAll()
    }

    fun addMessage(message: Message) {
        repository.save(message)
    }

}