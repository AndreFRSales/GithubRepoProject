package br.com.afrsales.github_repo_project.features.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.SavedStateHandle
import br.com.afrsales.github_repo_project.common.BaseViewModelTest
import br.com.afrsales.github_repo_project.common.mockEmptyState
import br.com.afrsales.github_repo_project.features.main.models.Owner
import br.com.afrsales.github_repo_project.features.main.models.Repository
import br.com.afrsales.github_repo_project.features.main.repository.RepositoriesRepository
import br.com.afrsales.github_repo_project.features.main.ui.MainViewModel
import br.com.afrsales.github_repo_project.features.main.ui.MainViewModelState
import io.mockk.*
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MainViewModelTest : BaseViewModelTest() {

    private val savedStateHandle: SavedStateHandle = mockk()
    private val repositoriesApi: RepositoriesRepository = mockk()

    private lateinit var viewModel: MainViewModel

    @Test
    fun `given call fetch repos then should emmit loading state`() {
        savedStateHandle.mockEmptyState()
        val observer = mockk<Observer<MainViewModelState>> { every { onChanged(any()) } just Runs }
        coEvery { repositoriesApi.getRepos("") } returns listOf(emptyRepository)

        viewModel = MainViewModel(repositoriesApi, savedStateHandle)

        viewModel.viewModelState.observeForever(observer)
        viewModel.fetchRepos()

        verify {
            observer.onChanged(MainViewModelState.Loading)
        }
    }

    @Test
    fun `given the repo has already loaded the first time than should not trigger the fetch repo`() {
        every {
            savedStateHandle.getLiveData<MainViewModelState>(any())
        } returns MutableLiveData(MainViewModelState.Data(listOf(emptyRepository)))

        viewModel = MainViewModel(repositoriesApi, savedStateHandle)

        coVerify(exactly = 0) {
            viewModel.fetchRepos()
        }
    }

    @Test
    fun `given api returns success when fetching repos than should has data`() {
        savedStateHandle.mockEmptyState()
        coEvery { repositoriesApi.getRepos("") } returns listOfRepositories

        viewModel = MainViewModel(repositoriesApi, savedStateHandle)

        viewModel.fetchRepos()

        assertEquals(viewModel.viewModelState.value, MainViewModelState.Data(listOfRepositories))
    }

    @Test
    fun `given api returns failure when fetching repos than should trigger Failure observe`() {
        savedStateHandle.mockEmptyState()
        coEvery { repositoriesApi.getRepos("") } throws Exception("Some error")

        viewModel = MainViewModel(repositoriesApi, savedStateHandle)

        viewModel.fetchRepos()

        assertEquals(viewModel.viewModelState.value, MainViewModelState.Error)
    }

}

val emptyRepository =
    Repository("", Owner("", ""), "")

val listOfRepositories = listOf(Repository("Name", Owner("Owner Name", "image_url"), "Description"))