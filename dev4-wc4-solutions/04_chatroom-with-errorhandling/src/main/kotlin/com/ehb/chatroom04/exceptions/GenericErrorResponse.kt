package com.ehb.chatroom04.exceptions

class GenericErrorResponse ( var status : Int? = null,
                             var message : String? = null,
                             var timeStamp : Long? = null,
                             var generic: String = "This is SO generic!"){
}