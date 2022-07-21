package com.pandasby.pettest.domain.usecases

import com.pandasby.pettest.domain.repos.DnDClassesRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DnDClassesUseCase @Inject constructor(
    private val repository: DnDClassesRepository
) : BaseUseCase() {

    suspend fun getClasses() = withContext(dispatcherIO) {
        val classes = repository.getClasses()

        //fetch details for each class. Collection order safe
        val details = classes
            .map { dnDClass -> dnDClass.detailsUrl }
            .map {
                async(dispatcherIO) {
                    repository.getClassDetails(it)
                }
            }.awaitAll()

        classes.forEachIndexed { i, dnDClass ->
            dnDClass.details = details[i]
        }

        return@withContext classes
    }
}