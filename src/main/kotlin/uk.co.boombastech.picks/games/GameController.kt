package uk.co.boombastech.picks.games

import org.springframework.web.bind.annotation.*
import uk.co.boombastech.picks.domain.Game
import uk.co.boombastech.picks.domain.toTeam

@RestController
@RequestMapping("/games")
class GameController(private val gameRepository: GameRepository) {

    @PostMapping("/add")
    fun addGames(@RequestBody games: List<Game>) {
        gameRepository.saveAll(games)
    }

    @PostMapping("/{gameId}/winner/{winningTeam}")
    fun setWinnerForGame(@PathVariable gameId: Int, @PathVariable winningTeam: String) {
        gameRepository.findById(gameId).ifPresent { game ->
            val team = winningTeam.toTeam()
            if (team != null) {
                game.winner = team
                gameRepository.save(game)
            }
        }
    }
}