package com.ehb.chatroom04.repositories

import com.ehb.chatroom04.models.Message
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MessageRepository : JpaRepository<Message, Long> {
}