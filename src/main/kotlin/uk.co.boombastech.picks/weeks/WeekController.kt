package uk.co.boombastech.picks.weeks

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import uk.co.boombastech.picks.domain.Week
import uk.co.boombastech.picks.domain.toWeekName

@RestController
@RequestMapping("/week")
class WeekController(private val repository: WeekService) {

    @GetMapping("/{week}")
    fun findByLastName(@PathVariable week: String): Week {
        val weekName = week.toWeekName()
        return repository.getWeek(weekName!!)
    }
}