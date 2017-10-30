package uk.co.boombastech.picks.domain

import javax.persistence.*

@Entity
data class Game(
        val season: Int,
        val week: WeekName,
        val homeTeam: Team,
        val awayTeam: Team,
        var winner: Team? = null,
        @OneToMany(mappedBy = "game", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        val picks: List<PlayerPick> = listOf(),
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Int = -1
)