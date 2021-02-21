package br.com.afrsales.github_repo_project.features.main.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import br.com.afrsales.github_repo_project.common.Status
import br.com.afrsales.github_repo_project.common.catching
import br.com.afrsales.github_repo_project.extensions.launch
import br.com.afrsales.github_repo_project.features.main.models.Repository
import br.com.afrsales.github_repo_project.features.main.repository.RepositoriesRepository

class MainViewModel(
    private val repositoriesRepository: RepositoriesRepository,
    private val viewModelStateHandle: SavedStateHandle
) : ViewModel() {

    private val _viewModelState =
        viewModelStateHandle.getLiveData<MainViewModelState>("mainState")
    val viewModelState: LiveData<MainViewModelState> get() = _viewModelState

    private var searchText: String = ""

    init {
        if (_viewModelState.value == null) fetchRepos()
    }

    fun fetchRepos(value: String = "") {
        searchText = value
        _viewModelState.value = MainViewModelState.Loading
        launch {
            val response = catching {
                repositoriesRepository.getRepos(value)
            }
            when(response) {
                is Status.Success -> _viewModelState.value = MainViewModelState.Data(response.data)
                is Status.Failure -> _viewModelState.value = MainViewModelState.Error
            }
        }
    }

    fun retry() {
        fetchRepos(searchText)
    }

}

sealed class MainViewModelState {
    data class Data(val repositories: List<Repository>) : MainViewModelState()
    object Loading : MainViewModelState()
    object Error : MainViewModelState()

}