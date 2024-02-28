package com.example.kotlin.api.service

import com.example.kotlin.api.repository.entity.ExampleEntity
import com.example.kotlin.api.repository.ExampleRepository
import org.springframework.stereotype.Service

@Service
class ExampleService(private val exampleRepository: ExampleRepository) {

    fun getAllExamples(): List<ExampleEntity> {
        return exampleRepository.findAll()
    }

    fun getExampleById(id: Long): ExampleEntity {
        return exampleRepository.findById(id).orElseThrow { NoSuchElementException("Example not found for id: $id") }
    }

    fun createExample(example: ExampleEntity): ExampleEntity {
        return exampleRepository.save(example)
    }

    fun updateExample(id: Long, updatedExample: ExampleEntity): ExampleEntity {
        if (!exampleRepository.existsById(id)) {
            throw NoSuchElementException("Example not found for id: $id")
        }
        updatedExample.id = id // Ensure the ID remains the same
        return exampleRepository.save(updatedExample)
    }

    fun deleteExample(id: Long) {
        if (!exampleRepository.existsById(id)) {
            throw NoSuchElementException("Example not found for id: $id")
        }
        exampleRepository.deleteById(id)
    }
}