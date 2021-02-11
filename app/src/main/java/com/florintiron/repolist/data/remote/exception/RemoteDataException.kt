package com.florintiron.repolist.data.remote.exception

/**
 * Created by Florin Tiron on 04/10/2020.
 */
sealed class RemoteDataException(message: String?) : Exception(message) {
    object NetworkConnection : RemoteDataException(message = "Unable to reach server")
    class ResponseError(message: String?) : RemoteDataException(message)
    class ServerError(code: Int) : RemoteDataException(message = "Server responded with code $code")
}