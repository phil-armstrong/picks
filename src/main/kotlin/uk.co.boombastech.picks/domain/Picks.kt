package uk.co.boombastech.picks.domain

data class Picks(
        val playerId: Int,
        val gamePicks: List<GamePick>
)