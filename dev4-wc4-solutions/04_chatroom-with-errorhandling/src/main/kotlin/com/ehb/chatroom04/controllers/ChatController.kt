package com.ehb.chatroom04.controllers

import com.ehb.chatroom04.dto.MessageResponse
import com.ehb.chatroom04.dto.NewChatRequest
import com.ehb.chatroom04.exceptions.ChatNotAllowedException
import com.ehb.chatroom04.models.Message
import com.ehb.chatroom04.services.ChatService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("chat")
class ChatController {

    // DONE 2 more repositories: MessageRepository and ChatroomRepository
    // DONE - Both inherit JpaRepository
    // DONE 1 service: ChatService
    // DONE - 2 functions: newChatMessage and getAllMessages
    // DONE 1 dto: NewChatRequest with "chatroomName: String, userId: Long, message: String"
    @Autowired
    lateinit var chatService: ChatService

    @PostMapping
    fun newChatMessage(@RequestBody ncr: NewChatRequest): Message {
        throw ChatNotAllowedException("You keep my wife's name out of your goddamn mouth!")
        return chatService.newChatMessage(ncr)

    }

    @GetMapping("messages")
    fun getAllMessages(): List<MessageResponse> {
        //Break things... for science!
        throw ArithmeticException("This is a NON issue. I swear");

        var tempList = chatService.getAllMessages()
        return convertList(tempList);
    }

    fun convertList(list: MutableList<Message>): List<MessageResponse> {


        var messageresponseList = mutableListOf<MessageResponse>();
        for (m in list){
            messageresponseList.add(
                MessageResponse(
                    message = m.value,
                    userId = m.user.id,
                    chatroomId = m.chatroom.id,
                    time = m.time)
            )
        }
        return messageresponseList;
    }
}