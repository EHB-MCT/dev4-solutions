package com.ehb.wc4relationschatroom.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.OneToMany

@Entity
data class Chatroom(
    @Id
    @GeneratedValue
    var id: Long = -1,
    var name: String,
    var iconUrl: String

){
    @ManyToMany
    open var users: List<User> = listOf()

    @OneToMany
    open var messages: List<Message> = listOf()

}
