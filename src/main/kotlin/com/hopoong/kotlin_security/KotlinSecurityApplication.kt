package com.hopoong.kotlin_security

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.PropertySource

@SpringBootApplication
@PropertySource("file:./pwd.ini")
class KotlinSecurityApplication

fun main(args: Array<String>) {
	runApplication<KotlinSecurityApplication>(*args)
}
