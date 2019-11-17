package `in`.squrlabs.remote.util

sealed class DtoResponse<out T : Any> {
    class Success<out T : Any>(val data: T) : DtoResponse<T>()
    class Error(val exception: Throwable) : DtoResponse<Nothing>()
}