package com.dev4.wc7gitbingo.models;

import javax.persistence.*;

@Entity
class Option (
    @Id @GeneratedValue var id: Long? = null,
    var content: String
) {}
