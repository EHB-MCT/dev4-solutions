package com.dev4.thymeleaf2.repositories

import com.dev4.thymeleaf2.models.Message
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MessageRepository : JpaRepository<Message, Long> {


}