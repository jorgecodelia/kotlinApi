package com.example.kotlin.api.repository

import com.example.kotlin.api.repository.entity.ExampleEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ExampleRepository : JpaRepository<ExampleEntity, Long>