package uk.co.boombastech.picks.players

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/players")
class PlayerController(private val repository: PlayerRepository) {

    @GetMapping("/")
    fun findAll() = repository.findAll()
}