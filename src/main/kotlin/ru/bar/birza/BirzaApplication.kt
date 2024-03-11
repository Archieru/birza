package ru.bar.birza

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BirzaApplication

fun main(args: Array<String>) {
	runApplication<BirzaApplication>(*args)
}
