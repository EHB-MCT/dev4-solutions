package com.ehb.chatroom04.exceptions

class UserNotFoundResponse(var status : Int? = null,
                           var message : String? = null,
                           var timeStamp : Long? = null,
                           var info : String = "Tip: Maybe create the user account first!"
) {
}