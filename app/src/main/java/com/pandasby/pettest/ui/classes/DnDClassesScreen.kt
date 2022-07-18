package com.pandasby.pettest.ui.classes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

const val DND_CLASSES_SCREEN = "DND_CLASSES_SCREEN"

@Composable
fun DnDClassesScreen() {
    val viewModel: DnDClassesViewModel = hiltViewModel()
    val classes = viewModel.classes.collectAsState(initial = emptyList())

    LazyColumn(
        modifier = Modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        items(classes.value) {
            DnDClassItem(it)
        }
    }
}