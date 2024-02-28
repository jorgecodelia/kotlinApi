package com.example.kotlin.api.common.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer

@Configuration
@EnableWebSecurity
class SecurityConfig  {

    @Throws(Exception::class)
    fun configure(http: HttpSecurity) {
        http.authorizeHttpRequests().anyRequest().permitAll()
    }
}