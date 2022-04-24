package com.ehb.chatroom04.exceptions

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest


@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler
    fun handleGenericException(exc : Exception) : ResponseEntity<GenericErrorResponse> {

        val errorResponse = GenericErrorResponse(HttpStatus.BAD_REQUEST.value(),
            exc.message,
            System.currentTimeMillis())

        return ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler
    fun handleFilthyChat(ex: ChatNotAllowedException): ResponseEntity<ChatNotAllowedResponse> {
        val chatResponse = ChatNotAllowedResponse(HttpStatus.BAD_REQUEST.value(),
                                                  ex.message,
                                                  System.currentTimeMillis())

        return ResponseEntity(chatResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    fun handleUserNotFound(ex: UserNotFoundException): ResponseEntity<UserNotFoundResponse> {
        val userResponse = UserNotFoundResponse(HttpStatus.BAD_REQUEST.value(),
            ex.message,
            System.currentTimeMillis())

        return ResponseEntity(userResponse, HttpStatus.BAD_REQUEST);
    }


}