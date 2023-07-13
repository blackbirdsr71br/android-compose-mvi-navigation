package com.br.alex.kotlin.android.githubcompose.ui.feature.repos.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.br.alex.kotlin.android.githubcompose.data.model.Repo
import com.br.alex.kotlin.android.githubcompose.data.model.RepoPreview

@Composable
fun ReposList(
    header: @Composable () -> Unit,
    reposList: List<com.br.alex.kotlin.android.githubcompose.data.model.Repo>,
) {
    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            item { header() }
            items(reposList) { repo ->
                ReposListItem(repo = repo)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReposListPreview() {
    val repos = List(3) { com.br.alex.kotlin.android.githubcompose.data.model.RepoPreview.repo }
    ReposList(header = {}, reposList = repos)
}