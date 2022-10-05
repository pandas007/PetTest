package com.pandasby.pettest.ui.spells

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
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
import com.pandasby.pettest.domain.entities.spells.DnDSpellDetails
import com.pandasby.pettest.ui.common.HtmlText
import com.pandasby.pettest.ui.common.TextTitleDescriptionCell

@Composable
fun DnDSpellItem(spell: DnDSpell) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    val borderColorAnimated by animateColorAsState(
        targetValue = if (expanded) Color.Blue else Color.Transparent,
        animationSpec = tween(600)
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable(
                interactionSource = MutableInteractionSource(),
                indication = null
            ) { expanded = !expanded }
            .border(
                width = 1.dp,
                shape = RoundedCornerShape(4.dp),
                color = borderColorAnimated
            )
            .shadow(4.dp)
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
            spell.details?.let {
                AnimatedVisibility(visible = expanded) {
                    DnDSpellItemDetails(dnDSpellDetails = it, modifier = Modifier.fillMaxWidth())
                }
            }
        }
    }
}

@Composable
fun DnDSpellItemDetails(dnDSpellDetails: DnDSpellDetails, modifier: Modifier = Modifier) {
    Column(modifier = modifier.clickable(enabled = false) {}) {
        TextTitleDescriptionCell(
            title = "Время накладывания",
            description = dnDSpellDetails.time
        )
        TextTitleDescriptionCell(
            title = "Дистанция",
            description = dnDSpellDetails.range
        )
        TextTitleDescriptionCell(
            title = "Длительность",
            description = dnDSpellDetails.duration
        )
        HtmlText(dnDSpellDetails.description)
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
            detailsUrl = "",
            details = DnDSpellDetails(
                description = "Крутое заклинание, которое что-то делает супер магическое",
                time = "1 действие",
                range = "60 футов",
                duration = "10 минут",
                url = ""
            )
        )
    )
}