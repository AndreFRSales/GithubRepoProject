package br.com.afrsales.github_repo_project.features.main.models.mapper

import br.com.afrsales.github_repo_project.features.main.models.*
import junit.framework.TestCase
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class RepositoriesMapperTest {

    @Test
    fun `given has response than should map to domain model`() {
        val mapper = RepositoriesMapper()
        val repoResponse = RepositoryResponse("Name", OwnerResponse("Owner Name", "url"), "Description")
        val repositoryDomainModel = mapper.map(RepositoriesListResponse(listOf(repoResponse)))
        val repositoryExpected = listOf(Repository("Name", Owner("Owner Name", "url"), "Description"))
        assertEquals(repositoryDomainModel, repositoryExpected)
    }

}