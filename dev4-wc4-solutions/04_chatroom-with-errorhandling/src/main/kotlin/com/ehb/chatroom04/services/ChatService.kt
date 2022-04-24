package com.ehb.chatroom04.services

import com.ehb.chatroom04.dto.NewChatRequest
import com.ehb.chatroom04.models.Chatroom
import com.ehb.chatroom04.models.Message
import com.ehb.chatroom04.models.User
import com.ehb.chatroom04.repositories.ChatroomRepository
import com.ehb.chatroom04.repositories.MessageRepository
import com.ehb.chatroom04.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ChatService {

    @Autowired
    lateinit var messageRepository: MessageRepository
    @Autowired
    lateinit var userRepository: UserRepository
    @Autowired
    lateinit var chatroomRepository: ChatroomRepository

    fun newChatMessage(ncr: NewChatRequest): Message {
        // So much to check here
        //  Create new message variable
        var newMessage = Message(value = ncr.message, time = Date())
        // - Everything ok? Save the message and update all objects
        // - Does the chatroom exist? If not: create new chatroom
        var chatroom = chatroomRepository.findByName(ncr.chatroomName)

        if(chatroom.isPresent){
            newMessage.chatroom = chatroom.get()
        }else{
            val newChatroom = chatroomRepository.save(
                Chatroom(name = ncr.chatroomName, iconUrl = "default.png")
            )
            newMessage.chatroom = newChatroom
        }
        // - Does the user exist? If not: ERROR
        var temp: Optional<User> = userRepository.findById(ncr.userId)
        // We get back an Optional<User>. Let's map it to either User or Null
        if(temp.isPresent){
            newMessage.user = temp.get();
        }else{
            //Throw Error
        }
        //Save the message

        return messageRepository.save(newMessage)
    }

    fun getAllMessages(): MutableList<Message> {
        return messageRepository.findAll();
    }
}