package com.ehb.chatroom04.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToMany

@Entity
data class User(
    @Id
    @GeneratedValue
    var id: Long = -1,
    var username: String,
    var email: String,
    var picture: String
){
    @ManyToMany
    open var chatrooms: List<Chatroom> = listOf()



}
