package br.com.afrsales.github_repo_project.features.main.repository

import br.com.afrsales.github_repo_project.features.main.models.RepositoriesListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RepositoriesApi {

    @GET("search/repositories")
    suspend fun searchRepositories(
        @Query("q") searchValue: String,
        @Query("per_page") maxPage: Int = 100
    ): RepositoriesListResponse

}