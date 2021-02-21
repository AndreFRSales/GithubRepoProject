package br.com.afrsales.github_repo_project.features.main.di

import androidx.lifecycle.SavedStateHandle
import br.com.afrsales.github_repo_project.features.main.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainInjection = module {
    viewModel { (handle: SavedStateHandle) ->
        MainViewModel(get(), handle)
    }
}