package com.florintiron.xaporepolist.data.remote.github.datasource

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Florin Tiron on 06/10/2020.
 */
sealed class Source {
    internal abstract val queryText: String

    sealed class Trending(language: String) : Source() {
        internal val resultsCount = 20
        protected abstract val date: String
        override val queryText by lazy {
            "language:$language created:>$date"
        }

        class Weekly(language: String) : Trending(language) {
            override val date = getDateString(-7)
        }

        class Monthly(language: String) : Trending(language) {
            override val date = getDateString(-30)
        }

        class Daily(language: String) : Trending(language) {
            override val date = getDateString(-1)
        }

        internal fun getDateString(dayDifference: Int): String {
            val dateFormat = SimpleDateFormat("yyyy-MM-dd")
            val calendar = Calendar.getInstance()
            calendar.add(Calendar.DAY_OF_YEAR, dayDifference)
            return dateFormat.format(calendar.time)
        }

    }

    sealed class User(user: String) : Source() {
        override val queryText by lazy {
            "user:$user"
        }
    }

}