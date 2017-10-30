package uk.co.boombastech.picks.players

import org.springframework.data.repository.CrudRepository
import uk.co.boombastech.picks.domain.Player

interface PlayerRepository : CrudRepository<Player, Int> {
}