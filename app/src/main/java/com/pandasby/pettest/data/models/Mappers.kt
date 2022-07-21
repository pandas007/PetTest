package com.pandasby.pettest.data.models

import com.pandasby.pettest.domain.entities.DnDClass
import com.pandasby.pettest.domain.entities.DnDClassDetails
import com.pandasby.pettest.domain.entities.DnDClassTab

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

}