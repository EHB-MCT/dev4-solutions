package com.ehb.chatroom04.exceptions

class ChatNotAllowedResponse(var status : Int? = null,
                             var message : String? = null,
                             var timeStamp : Long? = null,
                             var filthyWords: List<String> = listOf("Kotlin", "Dirt", "Mud", "Rock")
) {
}