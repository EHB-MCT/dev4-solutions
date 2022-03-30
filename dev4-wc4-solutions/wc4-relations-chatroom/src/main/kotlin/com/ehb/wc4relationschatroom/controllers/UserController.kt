package com.ehb.wc4relationschatroom.controllers

import com.ehb.wc4relationschatroom.dto.CreateUserRequest
import com.ehb.wc4relationschatroom.models.User
import com.ehb.wc4relationschatroom.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("user")
class UserController {

    @Autowired
    lateinit var userService: UserService;

    @GetMapping
    fun index(): List<User> {
        //Get all users
        val users = userService.getAllUsers();

        return users;
    }

    @PostMapping
    fun saveUser(@RequestBody userRequest: CreateUserRequest): User {
        return userService.saveUser(userRequest)

    }



}