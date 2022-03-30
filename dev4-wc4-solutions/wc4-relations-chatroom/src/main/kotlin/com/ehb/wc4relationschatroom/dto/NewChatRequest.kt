package com.ehb.wc4relationschatroom.dto


class NewChatRequest(
     var chatroomName: String,
     var userId: Long,
     var message: String
) {
}