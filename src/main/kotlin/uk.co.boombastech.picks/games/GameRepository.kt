package uk.co.boombastech.picks.games

import org.springframework.data.repository.CrudRepository
import uk.co.boombastech.picks.domain.Game
import uk.co.boombastech.picks.domain.WeekName

interface GameRepository : CrudRepository<Game, Int> {

    fun findByWeek(week: WeekName): List<Game>
}