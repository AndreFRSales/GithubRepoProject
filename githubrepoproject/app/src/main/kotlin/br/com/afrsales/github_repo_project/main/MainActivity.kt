package br.com.afrsales.github_repo_project.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import br.com.afrsales.github_repo_project.R
import br.com.afrsales.github_repo_project.main.repository.RepositoriesApi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val apiInterface: RepositoriesApi by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).launch {
            val result = apiInterface.searchRepositories("repo:")
            Log.d("Resultado", result.toString())
        }
    }
}