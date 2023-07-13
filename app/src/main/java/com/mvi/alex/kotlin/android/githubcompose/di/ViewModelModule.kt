package com.mvi.alex.kotlin.android.githubcompose.di




import com.mvi.alex.kotlin.android.githubcompose.ui.feature.repos.ReposViewModel
import com.mvi.alex.kotlin.android.githubcompose.ui.feature.users.UsersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        UsersViewModel(githubRepository = get())
    }

    viewModel { parameters ->
        ReposViewModel(
            userId = parameters.get(),
            githubRepository = get()
        )
    }
}
