package com.mvi.alex.kotlin.android.githubcompose.di

import com.mvi.alex.kotlin.android.githubcompose.data.GithubRepository
import com.mvi.alex.kotlin.android.githubcompose.data.GithubRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {

    factory<GithubRepository> {
        GithubRepositoryImpl(
            githubApi = get()
        )
    }

}