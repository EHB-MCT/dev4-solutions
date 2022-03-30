package com.ehb.wc4relationschatroom.services

import com.ehb.wc4relationschatroom.dto.CreateUserRequest
import com.ehb.wc4relationschatroom.models.User
import com.ehb.wc4relationschatroom.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    lateinit var userRepo: UserRepository

    fun getAllUsers(): List<User> {
        return userRepo.findAll()
    }

    fun saveUser(user: CreateUserRequest): User {
        val u = User(username = user.username, email = user.email, picture = user.picture);

        return userRepo.save(u);

    }
}