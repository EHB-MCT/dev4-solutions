package com.ehb.wc4relationschatroom.controllers

import com.ehb.wc4relationschatroom.dto.MessageResponse
import com.ehb.wc4relationschatroom.dto.NewChatRequest
import com.ehb.wc4relationschatroom.models.Message
import com.ehb.wc4relationschatroom.services.ChatService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

//This controller handles everything regarding chat, messages and in between

@RestController
@RequestMapping("chat")
class ChatController {

    @Autowired
    lateinit var chatService: ChatService

    @PostMapping
    fun chat(@RequestBody chatRequest: NewChatRequest): Message {
        //We need to do a whole lot
        // so we'll code that in the service
        return chatService.newMessage(chatRequest)

    }

    @GetMapping
    fun getMessages(): List<MessageResponse>{
        var tempList = chatService.getMessages();
        return convertList(tempList);
    }

    fun convertList(list: List<Message>): List<MessageResponse>{
        var messageResponseList = mutableListOf<MessageResponse>()
        for (m in list){
            messageResponseList.add(
                MessageResponse(
                    message = m.value,
                    userId = m.user.id,
                    chatroomId = m.chatroom.id,
                    time = m.time))
        }

        return messageResponseList;
    }

}