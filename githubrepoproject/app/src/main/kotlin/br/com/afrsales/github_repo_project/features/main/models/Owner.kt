package br.com.afrsales.github_repo_project.features.main.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Owner(val name: String, val avatarUrl: String) : Parcelable
