package com.ehb.wc4relationschatroom.services

import com.ehb.wc4relationschatroom.dto.NewChatRequest
import com.ehb.wc4relationschatroom.models.Chatroom
import com.ehb.wc4relationschatroom.models.Message
import com.ehb.wc4relationschatroom.models.User
import com.ehb.wc4relationschatroom.repositories.ChatroomRepository
import com.ehb.wc4relationschatroom.repositories.MessageRepository
import com.ehb.wc4relationschatroom.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ChatService {

    @Autowired lateinit var messageRepository: MessageRepository
    @Autowired lateinit var userRepository: UserRepository
    @Autowired lateinit var chatroomRepository: ChatroomRepository


    fun newMessage( chatRequest: NewChatRequest): Message {
        // So much to check here
        var newMessage = Message(value = chatRequest.message, time = Date());
        // - Everything ok? Save the message and update all objects

        // - Does the chatroom exist? If not: create new chatroom
        var chatroom = chatroomRepository.findByName(chatRequest.chatroomName)

        if(!chatroom.isPresent){
            val newChatroom = chatroomRepository.save(
                Chatroom(name = chatRequest.chatroomName, iconUrl = "default.jpg"))
            newMessage.chatroom = newChatroom
        }else{
            newMessage.chatroom = chatroom.get()
        }
        // Set the chatroom for the message


        // - Does the user exist? If not: error "This is not a valid user"
        var temp: Optional<User> = userRepository.findById(chatRequest.userId)
        // We get back an Optional<User>. Let's map it to either User or Null
        if(temp.isPresent){
            newMessage.user = temp.get();
        }else{
            //Throw Error
        }

        //Save the message
        return messageRepository.save(newMessage);

    }

    fun getMessages(): List<Message> {
        return messageRepository.findAll();
    }


}