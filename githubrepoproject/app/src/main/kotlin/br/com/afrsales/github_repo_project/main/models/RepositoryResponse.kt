package br.com.afrsales.github_repo_project.main.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RepositoryResponse(@SerialName("full_name") val fullName: String,
                              @SerialName("owner") val owner: OwnerResponse)