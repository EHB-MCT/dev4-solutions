package com.ehb.chatroom04.dto

data class NewChatRequest(var chatroomName: String,
                          var userId: Long,
                          var message: String)
