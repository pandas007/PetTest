package com.pandasby.pettest.ui.spells

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pandasby.pettest.R
import com.pandasby.pettest.domain.entities.spells.DnDSpell
import com.pandasby.pettest.domain.entities.spells.DnDSpellComponent

@Composable
fun DnDSpellItem(spell: DnDSpell) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Column(modifier = Modifier.padding(4.dp)) {
            Row {
                Text(text = spell.nameRus, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "[${spell.nameEng}]",
                    fontWeight = FontWeight.Light,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = stringResource(R.string.spell_level, spell.level),
                    fontStyle = FontStyle.Italic
                )
                Text(
                    text = spell.components.map { it.symbol }.joinToString(" "),
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Bottom),
                    textAlign = TextAlign.End,
                    fontWeight = FontWeight.Light,
                    fontSize = 10.sp
                )
            }

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
                DnDSpellComponent.Verbal,
                DnDSpellComponent.Somatic,
                DnDSpellComponent.Material("Player's hand")
            ),
            source = "PHB",
            detailsUrl = ""
        )
    )
}