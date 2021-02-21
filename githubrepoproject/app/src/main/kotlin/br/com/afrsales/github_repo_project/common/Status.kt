package br.com.afrsales.github_repo_project.common

sealed class Status<out T : Any> {

    data class Success<out T : Any>(val data: T) : Status<T>()
    object Failure : Status<Nothing>()
}