package com.pandasby.pettest.data.models

import com.pandasby.pettest.data.models.spells.DnDSpellModel
import com.pandasby.pettest.domain.entities.DnDClass
import com.pandasby.pettest.domain.entities.DnDClassDetails
import com.pandasby.pettest.domain.entities.DnDClassTab
import com.pandasby.pettest.domain.entities.spells.DnDSpell
import com.pandasby.pettest.domain.entities.spells.DnDSpellComponent

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

    private fun mapSpellComponents(model: DnDSpellModel.DnDSpellComponentsModel?): List<DnDSpellComponent> {
        if (model == null) return emptyList()

        val components = mutableListOf<DnDSpellComponent>()
        if (model.v == true) components.add(DnDSpellComponent.VERBAL)
        if (model.s == true) components.add(DnDSpellComponent.SOMATIC)
        if (model.m == true) components.add(DnDSpellComponent.MATERIAL)

        return components
    }
}