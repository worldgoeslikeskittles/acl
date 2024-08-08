package com.example.acl

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AclDemoApplication

fun main(args: Array<String>) {
	runApplication<AclDemoApplication>(*args)
}
