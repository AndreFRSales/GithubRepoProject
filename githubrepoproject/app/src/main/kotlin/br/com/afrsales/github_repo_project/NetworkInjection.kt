package br.com.afrsales.github_repo_project

import br.com.afrsales.github_repo_project.main.repository.RepositoriesApi
import br.com.afrsales.github_repo_project.network.AppConfig.BASE_URL
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create

@ExperimentalSerializationApi
val networkModule = module {

    single {
        val contentType = "application/json".toMediaType()
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                Json {
                    ignoreUnknownKeys = true
                }.asConverterFactory(contentType)
            )
            .client(get())
            .build()

    }

    factory {
        OkHttpClient.Builder().addInterceptor(get() as HttpLoggingInterceptor).build()
    }

    factory {
        HttpLoggingInterceptor()
            .apply { level = HttpLoggingInterceptor.Level.BODY }
    }

    factory {
        (get() as Retrofit).create<RepositoriesApi>()
    }
}