package com.florintiron.xaporepolist.data.util

/**
 * Created by Florin Tiron on 04/10/2020.
 */
sealed class DataResult<out T> {

    data class Success<out T>(val data: T) : DataResult<T>()
    data class Error(val exception: Exception) : DataResult<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}
