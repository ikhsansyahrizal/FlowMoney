package com.research.flowmoney.core.model

sealed class DataState<out T: Any> {

    class Success<out T: Any>(val data: T):DataState<T>()

    class Error(val error: String): DataState<Nothing>()

}