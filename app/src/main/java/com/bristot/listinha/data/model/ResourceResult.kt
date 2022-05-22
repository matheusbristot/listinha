package com.bristot.listinha.data.model

sealed class ResourceResult<out T>(val data: T?, val message: String?) {

    data class Success<out R>(private val _data: R?) : ResourceResult<R>(
        data = _data,
        message = null
    )

    data class Error(val exception: String) : ResourceResult<Nothing>(
        data = null,
        message = exception
    )
}