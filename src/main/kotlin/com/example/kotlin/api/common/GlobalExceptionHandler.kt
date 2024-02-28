package com.example.kotlin.api.common

import com.example.kotlin.api.common.domain.MainApiResponse
import com.example.kotlin.api.common.exception.BadRequestException
import com.example.kotlin.api.common.exception.ForbiddenException
import com.example.kotlin.api.common.exception.NoContentException
import com.example.kotlin.api.common.exception.NotFoundException
import com.example.kotlin.api.common.exception.ServiceException
import com.example.kotlin.api.common.exception.UnauthorizedException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException::class)
    fun handleException(ex: BadRequestException): ResponseEntity<MainApiResponse> {
        return getEmptyDataResponseResponseEntity(ex, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(ForbiddenException::class)
    fun handleException(ex: ForbiddenException): ResponseEntity<MainApiResponse> {
        return getEmptyDataResponseResponseEntity(ex, HttpStatus.FORBIDDEN)
    }

    @ExceptionHandler(NoContentException::class)
    fun handleException(ex: NoContentException): ResponseEntity<MainApiResponse> {
        return getEmptyDataResponseResponseEntity(ex, HttpStatus.NO_CONTENT)
    }

    @ExceptionHandler(NotFoundException::class)
    fun handleException(ex: NotFoundException): ResponseEntity<MainApiResponse> {
        return getEmptyDataResponseResponseEntity(ex, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(UnauthorizedException::class)
    fun handleException(ex: UnauthorizedException): ResponseEntity<MainApiResponse> {
        return getEmptyDataResponseResponseEntity(ex, HttpStatus.UNAUTHORIZED)
    }

    @ExceptionHandler(ServiceException::class)
    fun handleException(ex: ServiceException): ResponseEntity<MainApiResponse> {
        return getEmptyDataResponseResponseEntity(ex, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(Exception::class)
    fun handleException(ex: Exception): ResponseEntity<MainApiResponse> {
        return getEmptyDataResponseResponseEntity(ex, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    fun getEmptyDataResponseResponseEntity(ex: Exception, httpStatus: HttpStatus): ResponseEntity<MainApiResponse> {
        return ResponseEntity.status(httpStatus).body(MainApiResponse(ex.message.toString(),httpStatus.reasonPhrase,httpStatus.value()))
    }
}