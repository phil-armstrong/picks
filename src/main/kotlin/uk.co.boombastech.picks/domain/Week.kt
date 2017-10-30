package uk.co.boombastech.picks.domain

data class Week(
        val weekName: WeekName,
        val games: List<Game> = listOf(),
        val results: Map<Player, Int>
)