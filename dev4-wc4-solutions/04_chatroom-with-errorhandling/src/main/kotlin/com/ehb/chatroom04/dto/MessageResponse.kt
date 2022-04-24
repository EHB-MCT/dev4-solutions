package com.ehb.chatroom04.dto

import java.util.*

data class MessageResponse(val message: String, val userId: Long,
                           val chatroomId: Long, val time: Date
)
