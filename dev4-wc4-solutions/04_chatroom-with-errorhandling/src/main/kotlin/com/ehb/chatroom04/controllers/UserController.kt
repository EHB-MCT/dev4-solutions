package com.ehb.chatroom04.controllers

import com.ehb.chatroom04.dto.CreateUserRequest
import com.ehb.chatroom04.exceptions.UserNotFoundException
import com.ehb.chatroom04.exceptions.UserNotFoundResponse
import com.ehb.chatroom04.models.User
import com.ehb.chatroom04.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("users")
class UserController {

    @Autowired
    lateinit var service: UserService

    @GetMapping
    fun index(): MutableList<User> {
        throw UserNotFoundException("User is not found!");
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    fun findUser(@PathVariable id: Long): Optional<User> {

        return service.getUserById(id);
    }

    @PostMapping
    fun saveUser(@RequestBody u: CreateUserRequest): User {
        return service.saveUser(u)
    }


}