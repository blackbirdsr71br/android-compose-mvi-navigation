package com.br.wcabral.kotlin.android.githubcompose.data

import com.br.alex.kotlin.android.githubcompose.data.model.Repo
import com.br.alex.kotlin.android.githubcompose.data.model.User
import com.br.alex.kotlin.android.githubcompose.data.model.UserDetail
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class GithubRepositoryTest {

    private val githubApi = mockk<com.br.alex.kotlin.android.githubcompose.data.GithubApi>()
    private val githubRepository: com.br.alex.kotlin.android.githubcompose.data.GithubRepository =
        com.br.alex.kotlin.android.githubcompose.data.GithubRepositoryImpl(githubApi)

    @Test
    fun `When getUsers called then should call getUsers from the API`() = runTest {
        // Given
        val users = listOf(com.br.alex.kotlin.android.githubcompose.data.model.User())
        coEvery { githubApi.getUsers() } returns users

        // When
        val result = githubRepository.getUsers()

        // Then
        assert(result.isSuccess)
        coVerify(exactly = 1) { githubApi.getUsers() }
        confirmVerified(githubApi)
    }

    @Test
    fun `When getUser called then should call getUser from the API`() = runTest {
        // Given
        val userId = "wcabral"
        coEvery { githubApi.getUser(any()) } returns com.br.alex.kotlin.android.githubcompose.data.model.UserDetail()

        // When
        val result = githubRepository.getUser(userId)

        // Then
        assert(result.isSuccess)
        coVerify(exactly = 1) { githubApi.getUser(userId) }
        confirmVerified(githubApi)
    }

    @Test
    fun `When getRepos called then should call getRepos from the API`() = runTest {
        // Given
        val userId = "wcabral"
        coEvery { githubApi.getRepos(userId) } returns listOf(com.br.alex.kotlin.android.githubcompose.data.model.Repo())

        // When
        val result = githubRepository.getRepos(userId)

        // Then
        assert(result.isSuccess)
        coVerify(exactly = 1) { githubApi.getRepos(userId) }
        confirmVerified(githubApi)
    }

    @Test
    fun `Given an exception When getUsers called then returns failure`() = runTest {
        // Given
        coEvery { githubApi.getUsers() } throws Exception("")

        // When
        val result = githubRepository.getUsers()

        // Then
        assert(result.isFailure)
    }

    @Test
    fun `Given an exception When getUser called then returns failure`() = runTest {
        // Given
        coEvery { githubApi.getUser(any()) } throws Exception("")

        // When
        val result = githubRepository.getUser("wcabral")

        // Then
        assert(result.isFailure)
    }

    @Test
    fun `Given an exception When getRepos called then returns failure`() = runTest {
        // Given
        coEvery { githubApi.getRepos(any()) } throws Exception("")

        // When
        val result = githubRepository.getRepos("wcabral")

        // Then
        assert(result.isFailure)
    }
}