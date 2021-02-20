package br.com.afrsales.github_repo_project.main.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OwnerResponse(@SerialName("login") val ownerName: String)