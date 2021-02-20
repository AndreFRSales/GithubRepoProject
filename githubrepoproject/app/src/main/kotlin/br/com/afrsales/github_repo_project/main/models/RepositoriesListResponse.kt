package br.com.afrsales.github_repo_project.main.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RepositoriesListResponse(@SerialName("items") val repositoriesList: List<RepositoryResponse>)