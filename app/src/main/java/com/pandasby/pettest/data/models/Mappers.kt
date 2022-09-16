package com.pandasby.pettest.data.models

import com.pandasby.pettest.data.models.spells.DnDSpellDetailsModel
import com.pandasby.pettest.data.models.spells.DnDSpellModel
import com.pandasby.pettest.domain.entities.DnDClass
import com.pandasby.pettest.domain.entities.DnDClassDetails
import com.pandasby.pettest.domain.entities.DnDClassTab
import com.pandasby.pettest.domain.entities.spells.DnDSpell
import com.pandasby.pettest.domain.entities.spells.DnDSpellComponent
import com.pandasby.pettest.domain.entities.spells.DnDSpellDetails

object Mappers {

    fun DnDClassModel.toEntity() =
        DnDClass(
            name = this.name?.rusName.orEmpty(),
            dice = this.dice.orEmpty(),
            imageUrl = this.imageUrl.orEmpty(),
            detailsUrl = this.detailsUrl.orEmpty()
        )

    fun DnDClassDetailsModel.toEntity() =
        DnDClassDetails(
            tabs = this.tabs?.map {
                DnDClassTab(
                    name = it.tabName.orEmpty(),
                    type = DnDClassTab.Type.getTypeByName(it.type.orEmpty()),
                    url = it.url.orEmpty()
                )
            }.orEmpty()
        )

    fun DnDSpellModel.toEntity() =
        DnDSpell(
            nameRus = this.name?.rus.orEmpty(),
            nameEng = this.name?.eng.orEmpty(),
            level = this.level ?: -1,
            components = mapSpellComponents(this.components),
            source = this.source?.shortName.orEmpty(),
            detailsUrl = this.url.orEmpty()
        )

    fun DnDSpellDetailsModel.toEntity() =
        DnDSpellDetails(
            description = this.description.orEmpty(),
            time = this.time.orEmpty(),
            range = this.range.orEmpty(),
            duration = this.duration.orEmpty(),
            url = this.url.orEmpty()
        )

    private fun mapSpellComponents(model: DnDSpellModel.DnDSpellComponentsModel?): List<DnDSpellComponent> {
        if (model == null) return emptyList()

        val components = mutableListOf<DnDSpellComponent>()
        if (model.v == true) components.add(DnDSpellComponent.Verbal)
        if (model.s == true) components.add(DnDSpellComponent.Somatic)
        if (!model.m.isNullOrEmpty()) components.add(DnDSpellComponent.Material(model.m))

        return components
    }
}