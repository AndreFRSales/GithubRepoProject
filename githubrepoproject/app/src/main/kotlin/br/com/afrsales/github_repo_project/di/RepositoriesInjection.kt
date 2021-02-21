package br.com.afrsales.github_repo_project.di

import br.com.afrsales.github_repo_project.features.main.models.mapper.RepositoriesMapper
import br.com.afrsales.github_repo_project.features.main.repository.RepositoriesRepository
import org.koin.dsl.module

val repositoriesModule = module {
    single { RepositoriesMapper() }
    single { RepositoriesRepository(get(), get()) }
}