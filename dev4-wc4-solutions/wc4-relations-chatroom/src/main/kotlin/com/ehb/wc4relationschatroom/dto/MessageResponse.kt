package com.ehb.wc4relationschatroom.dto

import java.util.Date

data class MessageResponse(val message: String, val userId: Long,
                           val chatroomId: Long, val time: Date)
