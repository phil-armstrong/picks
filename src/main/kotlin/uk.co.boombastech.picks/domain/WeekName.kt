package uk.co.boombastech.picks.domain

enum class WeekName(val shortName: String) {
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    ELEVEN("11"),
    TWELVE("12"),
    THIRTEEN("13"),
    FOURTEEN("14"),
    FIFTEEN("15"),
    SIXTEEN("16"),
    SEVENTEEN("17"),
    WILDCARD("wc"),
    DIVISIONAL("div"),
    CONFERENCE("conf"),
    SUPER_BOWL("sb")
}

fun String.toWeekName(): WeekName? {
    return WeekName.values().firstOrNull { weekName -> weekName.shortName == this }
}