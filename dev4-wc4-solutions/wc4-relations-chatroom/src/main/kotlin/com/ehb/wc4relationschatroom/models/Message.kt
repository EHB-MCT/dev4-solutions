package com.ehb.wc4relationschatroom.models

import java.util.Date
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
data class Message(
    @Id
    @GeneratedValue
    var id:Long = -1,

    var value: String,
    var time: Date
){
    @ManyToOne
    open lateinit var chatroom: Chatroom

    @ManyToOne
    open lateinit var user: User
}
