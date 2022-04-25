package com.dev4.wc7gitbingo.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class Card(
    @Id @GeneratedValue var id: Long? = null,
    var name: String,
    var checked: Boolean = false
) {
    @OneToMany
    var values: List<Value> = listOf()
}