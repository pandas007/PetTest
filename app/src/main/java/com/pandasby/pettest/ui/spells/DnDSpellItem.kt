package com.pandasby.pettest.ui.spells

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pandasby.pettest.domain.entities.spells.DnDSpell
import com.pandasby.pettest.domain.entities.spells.DnDSpellComponent

@Composable
fun DnDSpellItem(spell: DnDSpell) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
    ) {
        Box(modifier = Modifier.padding(4.dp)) {
            Row(
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Text(text = spell.nameRus, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "[${spell.nameEng}]", fontWeight = FontWeight.Light)
            }
            Text(
                text = spell.components.map { it.name.first() }.joinToString(" "),
                modifier = Modifier.align(Alignment.BottomEnd),
                fontWeight = FontWeight.Light,
                fontSize = 10.sp
            )
        }
    }
}

@Preview
@Composable
fun DnDSpellItemPreview() {
    DnDSpellItem(
        DnDSpell(
            nameRus = "Волшебная рука",
            nameEng = "Magic hand",
            level = 0,
            components = listOf(
                DnDSpellComponent.VERBAL,
                DnDSpellComponent.SOMATIC,
                DnDSpellComponent.MATERIAL
            ),
            source = "PHB",
            detailsUrl = ""
        )
    )
}