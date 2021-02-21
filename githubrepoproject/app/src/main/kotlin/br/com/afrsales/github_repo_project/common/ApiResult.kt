package br.com.afrsales.github_repo_project.common

inline fun <T : Any> catching(block: () -> T): Status<T> = try {
    Status.Success(block())
} catch (exception: Throwable) {
        Status.Failure
}