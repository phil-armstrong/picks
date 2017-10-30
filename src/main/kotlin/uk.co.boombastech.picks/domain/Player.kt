package uk.co.boombastech.picks.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Player(
        val name: String,
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Int = -1
)