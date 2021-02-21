package br.com.afrsales.github_repo_project.common

import android.app.Application
import br.com.afrsales.github_repo_project.di.repositoriesModule
import br.com.afrsales.github_repo_project.di.networkModule
import br.com.afrsales.github_repo_project.features.main.di.mainInjection
import org.koin.core.context.startKoin

class CustomApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoinModules()
    }

    private fun startKoinModules() {
        startKoin {
            modules(networkModule, repositoriesModule, mainInjection)
        }
    }

}