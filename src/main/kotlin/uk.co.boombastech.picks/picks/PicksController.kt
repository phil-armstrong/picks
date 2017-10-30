package uk.co.boombastech.picks.picks

import org.springframework.web.bind.annotation.*
import uk.co.boombastech.picks.players.PlayerRepository
import uk.co.boombastech.picks.domain.GamePick
import uk.co.boombastech.picks.domain.Picks
import uk.co.boombastech.picks.domain.Player
import uk.co.boombastech.picks.domain.PlayerPick
import uk.co.boombastech.picks.games.GameRepository

@RestController
@RequestMapping("/picks")
class PicksController(
        private val gameRepository: GameRepository,
        private val playerRepository: PlayerRepository,
        private val playerPickRepository: PlayerPickRepository) {

    @PostMapping("/")
    fun pickGames(@RequestBody picks: Picks) {
        if (playerRepository.existsById(picks.playerId)) {
            val player = playerRepository.findById(picks.playerId).get()
            val playerPicks = picks.gamePicks
                    .filter { (gameId) -> gameRepository.existsById(gameId) }
                    .map { gamePick -> mapToPlayerPick(gamePick, player) }

            if (playerPicks.count(PlayerPick::lock) > 1) {
                // throw error for too many locks
            }

            playerPickRepository.saveAll(playerPicks)
        }
    }

    private fun mapToPlayerPick(gamePick: GamePick, player: Player): PlayerPick {
        val game = gameRepository.findById(gamePick.gameId).get()
        return PlayerPick(player, game, gamePick.team, gamePick.lock, gamePick.megaLock)
    }

    @GetMapping("/{playerId}")
    fun getPlayerPicks(@PathVariable playerId: Int): List<PlayerPick> {
        if (playerRepository.existsById(playerId)) {
            val player = playerRepository.findById(playerId).get()
            return playerPickRepository.findByPlayer(player)
        }

        return emptyList()
    }

}