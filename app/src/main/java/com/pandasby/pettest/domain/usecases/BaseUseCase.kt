package com.pandasby.pettest.domain.usecases

import com.pandasby.pettest.di.DispatcherDefault
import com.pandasby.pettest.di.DispatcherIO
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

abstract class BaseUseCase {

    @Inject
    @DispatcherIO
    protected lateinit var dispatcherIO: CoroutineDispatcher

    @Inject
    @DispatcherDefault
    protected lateinit var dispatcherDefault: CoroutineDispatcher
}