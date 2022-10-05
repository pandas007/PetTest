package com.pandasby.pettest.ui.spells

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

const val DND_CLASS_SPELLS_ID_ARG = "DND_CLASS_SPELLS_ID_ARG"
const val DND_CLASSES_SPELLS_SCREEN = "DND_CLASSES_SPELLS_SCREEN"

@Composable
fun DnDClassSpellsScreen(spellsUrl: String, viewModel: DnDClassSpellsViewModel = hiltViewModel()) {
    val spells = viewModel.spells.collectAsState(initial = emptyList())

    viewModel.getClassSpells(spellsUrl)

    LazyColumn(
        modifier = Modifier.padding(horizontal = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        items(
            items = spells.value,
            key = { it.nameRus }
        ) {
            DnDSpellItem(it)
        }
    }
}