package br.com.afrsales.github_repo_project.features.main.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Repository(val name: String, val owner: Owner, val description: String) : Parcelable