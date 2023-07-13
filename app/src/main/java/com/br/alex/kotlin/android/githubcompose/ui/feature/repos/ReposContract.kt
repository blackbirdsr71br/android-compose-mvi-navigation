package com.br.alex.kotlin.android.githubcompose.ui.feature.repos

import com.br.alex.kotlin.android.githubcompose.ui.base.ViewEvent
import com.br.alex.kotlin.android.githubcompose.ui.base.ViewSideEffect
import com.br.alex.kotlin.android.githubcompose.ui.base.ViewState


class ReposContract {

    sealed class Event : ViewEvent {
        object Retry : Event()
        object BackButtonClicked : Event()
    }

    data class State(
        val user: com.br.alex.kotlin.android.githubcompose.data.model.UserDetail?,
        val reposList: List<com.br.alex.kotlin.android.githubcompose.data.model.Repo>,
        val isUserLoading: Boolean,
        val isReposLoading: Boolean,
        val isError: Boolean,
    ) : ViewState

    sealed class Effect : ViewSideEffect {
        sealed class Navigation : Effect() {
            object Back : Navigation()
        }
    }

}
