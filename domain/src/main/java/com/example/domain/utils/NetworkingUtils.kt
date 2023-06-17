package com.example.domain.utils

import android.net.Uri

object NetworkingUtils {

    fun getNextPageNumberFromUri(nextPage: String?): String? {
        if (nextPage == null) return null
        return try {
            val uri = Uri.parse(nextPage)
            uri.getQueryParameter(PAGE_QUERY_PARAMETER)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
    private const val PAGE_QUERY_PARAMETER = "page"
}