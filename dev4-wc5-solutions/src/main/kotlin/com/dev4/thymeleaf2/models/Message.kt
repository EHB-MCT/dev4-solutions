package com.dev4.thymeleaf2.models

import javax.persistence.*

@Entity
class Message (
    var author: String = "",
    var message: String = "",
    @Id @GeneratedValue var id: Long? = null
)
