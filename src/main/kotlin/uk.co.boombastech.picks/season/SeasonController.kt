package uk.co.boombastech.picks.season

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import uk.co.boombastech.picks.weeks.WeekService
import uk.co.boombastech.picks.domain.Player
import uk.co.boombastech.picks.domain.Week
import uk.co.boombastech.picks.domain.WeekName

@RestController
@RequestMapping("/season")
class SeasonController(private val repository: WeekService) {

    @GetMapping("/{season}")
    fun findByLastName(@PathVariable season: String): Season {
        val weeks = WeekName.values().map { weekName ->
            repository.getWeek(weekName)
        }
        return Season(season, weeks)
    }
}

data class Season(
        val name: String,
        val weeks: List<Week>,
        val results: Map<Player, Int> = emptyMap()
)
