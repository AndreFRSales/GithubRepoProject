package br.com.afrsales.github_repo_project.features.main.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OwnerResponse(
    @SerialName("login") val ownerName: String,
    @SerialName("avatar_url") val avatarUrl: String
)