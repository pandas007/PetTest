package com.pandasby.pettest.domain.usecases

import com.pandasby.pettest.domain.repos.DnDClassesRepository
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DnDClassesUseCase @Inject constructor(
    private val repository: DnDClassesRepository
) : BaseUseCase() {

    suspend fun getClasses() = withContext(io) {
        repository.getClasses()
    }
}