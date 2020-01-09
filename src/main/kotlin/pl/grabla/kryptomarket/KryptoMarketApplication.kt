package pl.grabla.kryptomarket

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class KryptoMarketApplication

fun main(args: Array<String>) {
    runApplication<KryptoMarketApplication>(*args)
}

@RestController
class HelloController{

    @GetMapping
    fun getHello() = "Hello Wolrd!"
}