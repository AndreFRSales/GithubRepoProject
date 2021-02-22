package br.com.afrsales.github_repo_project.features.main.repository

import br.com.afrsales.github_repo_project.features.main.models.Repository
import br.com.afrsales.github_repo_project.features.main.models.mapper.RepositoriesMapper

class RepositoriesRepository(
    private val api: RepositoriesApi,
    private val mapper: RepositoriesMapper
) {

    companion object {
        private const val REPO_QUERY = "topic:"
    }

    suspend fun getRepos(searchValue: String): List<Repository> {
        val response = api.searchRepositories("$REPO_QUERY$searchValue")

        return mapper.map(response)
    }

}