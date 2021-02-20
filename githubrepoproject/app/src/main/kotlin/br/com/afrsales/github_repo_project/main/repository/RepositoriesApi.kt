package br.com.afrsales.github_repo_project.main.repository

import br.com.afrsales.github_repo_project.main.models.RepositoriesListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RepositoriesApi {

    @GET("search/repositories")
    suspend fun searchRepositories(@Query("q") searchValue: String): RepositoriesListResponse

}