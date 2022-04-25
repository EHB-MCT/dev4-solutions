package com.dev4.wc7gitbingo.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity
class Value (
    @Id @GeneratedValue var id: Long? = null,
    var position: Int,
    var content: String,
    var checked: Boolean = false,
    ) {
    @ManyToOne
    lateinit var card: Card

}