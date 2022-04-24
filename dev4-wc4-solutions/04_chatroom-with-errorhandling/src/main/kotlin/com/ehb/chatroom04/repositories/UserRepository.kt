package com.ehb.chatroom04.repositories

import com.ehb.chatroom04.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long>{
}