package uk.co.boombastech.picks.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class PlayerPick(
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "player_id")
        val player: Player,
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "game_id")
        @JsonIgnore
        val game: Game,
        val team: Team,
        val lock: Boolean = false,
        val megaLock: Boolean = false,
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Int = -1
)