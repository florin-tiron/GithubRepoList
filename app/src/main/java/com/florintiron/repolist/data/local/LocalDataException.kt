package com.florintiron.repolist.data.local

/**
 * Created by Florin Tiron on 05/10/2020.
 */
sealed class LocalDataException(message: String?) : Exception(message) {
    object Empty : LocalDataException(message = "No data available")
}