package com.dev4.thymeleaf2.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Student {
    var firstName: String = ""
    var lastName: String = ""
    var email: String = ""
    @Id @GeneratedValue var id: Long? = null
}