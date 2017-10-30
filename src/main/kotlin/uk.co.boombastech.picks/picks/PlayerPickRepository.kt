package uk.co.boombastech.picks.picks

import org.springframework.data.repository.CrudRepository
import uk.co.boombastech.picks.domain.Player
import uk.co.boombastech.picks.domain.PlayerPick

interface PlayerPickRepository : CrudRepository<PlayerPick, Int> {
    fun findByPlayer(player: Player): List<PlayerPick>
}