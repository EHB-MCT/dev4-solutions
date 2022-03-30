package com.ehb.wc4relationschatroom.repositories

import com.ehb.wc4relationschatroom.models.Message
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MessageRepository : JpaRepository<Message, Long> {
}