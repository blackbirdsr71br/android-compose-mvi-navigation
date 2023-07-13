package com.br.alex.kotlin.android.githubcompose.di

import com.br.alex.kotlin.android.githubcompose.data.GithubRepository
import com.br.alex.kotlin.android.githubcompose.data.GithubRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {

    factory<GithubRepository> {
        GithubRepositoryImpl(
            githubApi = get()
        )
    }

}