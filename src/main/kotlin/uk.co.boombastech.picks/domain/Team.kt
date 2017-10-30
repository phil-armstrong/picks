package uk.co.boombastech.picks.domain

enum class Team(val fullName: String = "") {
    // NFC East
    PHI("Philadelphia Eagles"),
    DAL("Dallas Cowboys"),
    NYG("New York Giants"),
    WAS("Washington Redskins"),
    // NFC West
    ARI("Arizona Cardinals"),
    SF("San Francisco 49ers"),
    LAR("Los Angeles Rams"),
    SEA("Seattle Seahawks"),
    // NFC North
    GB,
    MIN,
    DET,
    CHI,
    // NFC South
    ATL,
    CAR,
    NO,
    TB,
    // AFC East
    NE,
    MIA,
    NYJ,
    BUF,
    // AFC West
    KC,
    OAK,
    LAC,
    DEN,
    // AFC North
    PIT("Pittsburgh Steelers"),
    BAL("Baltimore Ravens"),
    CLE("Cleveland Browns"),
    CIN("Cincinatti Bengals"),
    // AFC South
    TEN,
    IND,
    JAC,
    HOU
}

fun String.toTeam(): Team? {
    return Team.values().firstOrNull { team -> team.name == this }
}