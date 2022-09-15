package com.pandasby.pettest.ui.classes

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
import androidx.navigation.NavController
import com.pandasby.pettest.domain.entities.DnDClassTab
import com.pandasby.pettest.ui.spells.DND_CLASSES_SPELLS_SCREEN
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

const val DND_CLASSES_SCREEN = "DND_CLASSES_SCREEN"

@Composable
fun DnDClassesScreen(navController: NavController) {
    val viewModel: DnDClassesViewModel = hiltViewModel()
    val classes = viewModel.classes.collectAsState(initial = emptyList())

    LazyColumn(
        modifier = Modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        items(classes.value) {
            DnDClassItem(it) { dndClass ->
                val url = dndClass
                    .details
                    ?.tabs
                    ?.find { classTab -> classTab.type == DnDClassTab.Type.SPELLS }
                    ?.url
                //needs to encode url to use it as a parameter within compose navigation
                val encodedUrl = URLEncoder.encode(url, StandardCharsets.UTF_8.toString())

                navController.navigate(
                    "$DND_CLASSES_SPELLS_SCREEN/$encodedUrl"
                )
            }
        }
    }
}