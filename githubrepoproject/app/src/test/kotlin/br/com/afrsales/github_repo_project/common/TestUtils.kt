package br.com.afrsales.github_repo_project.common

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import br.com.afrsales.github_repo_project.features.main.models.Repository
import io.mockk.every

fun SavedStateHandle.mockEmptyState() {
    every {
        getLiveData<List<Repository>>(any())
    } returns MutableLiveData(null)
}
