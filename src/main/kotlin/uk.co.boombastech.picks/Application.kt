package uk.co.boombastech.picks

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class Application {

    private val log = LoggerFactory.getLogger(Application::class.java)

    @Bean
    fun init() = CommandLineRunner {
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}
