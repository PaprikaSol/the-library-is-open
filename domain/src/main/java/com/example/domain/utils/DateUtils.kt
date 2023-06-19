package com.example.domain.utils

import kotlin.math.abs

object DateUtils {
    fun getLifeDuration(birthYear: Int?, deathYear: Int?): String =
        "${formatYear(birthYear)}-${formatYear(deathYear)}"

    private fun formatYear(year: Int?): String {
        if (year == null) return ""
        val absoluteYear = abs(year)
        val label = if (year < 0) BEFORE_CHRIST_STRING else if (year > 0) ANNO_DOMINI_STRING else ""
        return "$absoluteYear $label"
    }

    private const val BEFORE_CHRIST_STRING = "BC"
    private const val ANNO_DOMINI_STRING = "AD"
}