package com.example.kotlin.api.controller

import com.example.kotlin.api.repository.entity.ExampleEntity
import com.example.kotlin.api.service.ExampleService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.ResponseStatus

@RestController
@RequestMapping("/api/examples")
class ExampleController(private val exampleService: ExampleService) {

    @GetMapping
    fun getAllExamples(): List<ExampleEntity> {
        return exampleService.getAllExamples()
    }

    @GetMapping("/{id}")
    fun getExampleById(@PathVariable id: Long): ExampleEntity {
        return exampleService.getExampleById(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createExample(@RequestBody example: ExampleEntity): ExampleEntity {
        return exampleService.createExample(example)
    }

    @PutMapping("/{id}")
    fun updateExample(@PathVariable id: Long, @RequestBody updatedExample: ExampleEntity): ExampleEntity {
        return exampleService.updateExample(id, updatedExample)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteExample(@PathVariable id: Long) {
        exampleService.deleteExample(id)
    }
}