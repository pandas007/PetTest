package com.pandasby.pettest.ui.classes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pandasby.pettest.domain.entities.DnDClass
import com.pandasby.pettest.domain.usecases.DnDClassesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DnDClassesViewModel @Inject constructor(
    private val dndClassesUseCase: DnDClassesUseCase
) : ViewModel() {

    private val _classes: MutableStateFlow<List<DnDClass>> = MutableStateFlow(emptyList())
    val classes: Flow<List<DnDClass>> = _classes

    init {
        viewModelScope.launch {
            _classes.emit(dndClassesUseCase.getClasses())
        }
    }
}