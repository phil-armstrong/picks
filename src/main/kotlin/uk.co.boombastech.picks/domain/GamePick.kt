package uk.co.boombastech.picks.domain

import uk.co.boombastech.picks.domain.Team

data class GamePick(
        val gameId: Int,
        val team: Team,
        val lock: Boolean = false,
        val megaLock: Boolean = false
)