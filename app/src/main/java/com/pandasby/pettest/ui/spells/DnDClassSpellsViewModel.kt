package com.pandasby.pettest.ui.spells

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pandasby.pettest.domain.entities.spells.DnDSpell
import com.pandasby.pettest.domain.usecases.DnDClassesUseCase
import com.pandasby.pettest.domain.usecases.DnDSpellsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DnDClassSpellsViewModel @Inject constructor(
    private val spellsUseCase: DnDSpellsUseCase,
    private val classUseCase: DnDClassesUseCase
) : ViewModel(){

    private val _spells = MutableStateFlow<List<DnDSpell>>(emptyList())
    val spells: Flow<List<DnDSpell>> = _spells

    fun getClassSpells(spellsUrl: String) {
        viewModelScope.launch {
            val classSpellsId = classUseCase.getClassSpellsId(spellsUrl)
            _spells.emit(
                spellsUseCase.getClassSpells(classSpellsId)
            )
        }
    }
}