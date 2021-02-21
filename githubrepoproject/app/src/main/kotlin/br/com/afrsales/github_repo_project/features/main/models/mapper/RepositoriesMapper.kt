package br.com.afrsales.github_repo_project.features.main.models.mapper

import br.com.afrsales.github_repo_project.features.main.models.Owner
import br.com.afrsales.github_repo_project.features.main.models.RepositoriesListResponse
import br.com.afrsales.github_repo_project.features.main.models.Repository

class RepositoriesMapper {

    fun map(responseList: RepositoriesListResponse) = responseList.repositoriesList.map {
        Repository(it.fullName, Owner(it.owner.ownerName, it.owner.avatarUrl), it.description)
    }
}