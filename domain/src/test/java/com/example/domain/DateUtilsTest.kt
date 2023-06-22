package com.example.domain

import com.example.domain.utils.DateUtils
import org.junit.Assert.assertEquals
import org.junit.Test

class DateUtilsTest {

    @Test
    fun `getLifeDuration should return formatted life duration when both years AD`() {
        val birthYear = 1732
        val deathYear = 1780
        val result = DateUtils.getLifeDuration(birthYear, deathYear)
        assertEquals("1732 AD-1780 AD", result)
    }

    @Test
    fun `getLifeDuration should return formatted life duration when both years BC`() {
        val birthYear = -512
        val deathYear = -482
        val result = DateUtils.getLifeDuration(birthYear, deathYear)
        assertEquals("512 BC-482 BC", result)
    }

    @Test
    fun `getLifeDuration should return formatted life duration when birth BC and death AD`() {
        val birthYear = -33
        val deathYear = 58
        val result = DateUtils.getLifeDuration(birthYear, deathYear)
        assertEquals("33 BC-58 AD", result)
    }

    @Test
    fun `getLifeDuration should return formatted life duration when birth year null`() {
        val birthYear = null
        val deathYear = 652
        val result = DateUtils.getLifeDuration(birthYear, deathYear)
        assertEquals("-652 AD", result)
    }


    @Test
    fun `getLifeDuration should return formatted life duration when death year null`() {
        val birthYear = -423
        val deathYear = null
        val result = DateUtils.getLifeDuration(birthYear, deathYear)
        assertEquals("423 BC-", result)
    }


    @Test
    fun `getLifeDuration should return formatted life duration when both years are null`() {
        val birthYear = null
        val deathYear = null
        val result = DateUtils.getLifeDuration(birthYear, deathYear)
        assertEquals("", result)
    }
}