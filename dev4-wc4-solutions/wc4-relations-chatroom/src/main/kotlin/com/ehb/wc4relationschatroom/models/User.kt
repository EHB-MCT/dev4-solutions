package com.ehb.wc4relationschatroom.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.OneToMany

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

    @OneToMany
    open var messages: List<Message> = listOf()
}
