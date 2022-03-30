package com.ehb.wc4relationschatroom.repositories

import com.ehb.wc4relationschatroom.models.Chatroom
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ChatroomRepository : JpaRepository<Chatroom, Long> {

    @Query("SELECT c from Chatroom c where c.name = :name")
    fun findByName(@Param("name") name: String): Optional<Chatroom>
}