package com.ehb.chatroom04.services

import com.ehb.chatroom04.dto.CreateUserRequest
import com.ehb.chatroom04.exceptions.UserNotFoundException
import com.ehb.chatroom04.models.User
import com.ehb.chatroom04.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService {

    @Autowired
    lateinit var userRepository: UserRepository

    fun getAllUsers(): MutableList<User> {
        return userRepository.findAll()
    }

    fun getUserById(id: Long): Optional<User> {
        throw UserNotFoundException("I already know he/she does not exist!")

        return userRepository.findById(id);
    }

    fun saveUser(u: CreateUserRequest): User{
        val newUser = User(username = u.username, email = u.email, picture = u.picture)

        return userRepository.save(newUser);
    }
}