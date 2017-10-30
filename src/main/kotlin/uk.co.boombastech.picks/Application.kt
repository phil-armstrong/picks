package uk.co.boombastech.picks

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import uk.co.boombastech.picks.domain.Game
import uk.co.boombastech.picks.domain.Player
import uk.co.boombastech.picks.domain.PlayerPick
import uk.co.boombastech.picks.domain.Team.*
import uk.co.boombastech.picks.domain.WeekName
import uk.co.boombastech.picks.games.GameRepository
import uk.co.boombastech.picks.picks.PlayerPickRepository
import uk.co.boombastech.picks.players.PlayerRepository

@SpringBootApplication
class Application {

    private val log = LoggerFactory.getLogger(Application::class.java)

    @Bean
    fun init(gameRepository: GameRepository, playerRepository: PlayerRepository, playerPickRepository: PlayerPickRepository) = CommandLineRunner {
        val miaBal = gameRepository.save(Game(2017, WeekName.EIGHT, MIA, BAL, BAL))
        val minCle = gameRepository.save(Game(2017, WeekName.EIGHT, MIN, CLE, MIN))
        gameRepository.save(Game(2017, WeekName.EIGHT, OAK, BUF))
        gameRepository.save(Game(2017, WeekName.EIGHT, IND, CIN))
        gameRepository.save(Game(2017, WeekName.EIGHT, LAC, NE))
        gameRepository.save(Game(2017, WeekName.EIGHT, CHI, NO))
        gameRepository.save(Game(2017, WeekName.EIGHT, ATL, NYJ))
        gameRepository.save(Game(2017, WeekName.EIGHT, SF, PHI))
        gameRepository.save(Game(2017, WeekName.EIGHT, CAR, TB))
        gameRepository.save(Game(2017, WeekName.EIGHT, HOU, SEA))
        gameRepository.save(Game(2017, WeekName.EIGHT, DAL, WAS))
        gameRepository.save(Game(2017, WeekName.SIX, PIT, DET))
        gameRepository.save(Game(2017, WeekName.SIX, DEN, KC))

        val phil = playerRepository.save(Player("Phil"))

        playerPickRepository.save(PlayerPick(phil, miaBal, MIA))
        playerPickRepository.save(PlayerPick(phil, minCle, MIN, false, true))
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}
