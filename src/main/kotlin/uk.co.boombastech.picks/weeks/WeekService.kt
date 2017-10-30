package uk.co.boombastech.picks.weeks

import org.springframework.stereotype.Service
import uk.co.boombastech.picks.domain.PlayerPick
import uk.co.boombastech.picks.domain.Team
import uk.co.boombastech.picks.domain.Week
import uk.co.boombastech.picks.domain.WeekName
import uk.co.boombastech.picks.games.GameRepository
import uk.co.boombastech.picks.players.PlayerRepository

@Service
class WeekService(private val gameRepository: GameRepository, private val playerRepository: PlayerRepository) {

    fun getWeek(weekName: WeekName): Week {
        val games = gameRepository.findByWeek(weekName)

        val results = playerRepository.findAll().toList().associateBy({ it }, { player ->
            games.filter { it.winner != null }
                    .map { game ->
                        val playerPick = game.picks.find { pick -> pick.player == player }
                        if (playerPick != null) {
                            calculateScore(game.winner!!, playerPick)
                        } else {
                            0
                        }
                    }.sum()
        })

        return Week(weekName, games, results)
    }

    private fun calculateScore(winningTeam: Team, playerPick: PlayerPick): Int {
        return if (playerPick.team == winningTeam) {
            when {
                playerPick.lock -> 2
                playerPick.megaLock -> 5
                else -> 1
            }
        } else {
            when {
                playerPick.megaLock -> -5
                playerPick.lock -> -1
                else -> 0
            }
        }
    }
}