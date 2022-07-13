package com.pandasby.pettest.data.models

import com.pandasby.pettest.domain.entities.DnDClass

object Mappers {

    fun DnDClassModel.toEntity() =
        DnDClass(
            name = this.name?.rusName.orEmpty()
        )

}