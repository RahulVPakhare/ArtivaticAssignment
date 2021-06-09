package com.artivatic.assignment.repo

import com.artivatic.assignment.api.DataApi
import com.artivatic.assignment.model.Data
import com.artivatic.assignment.model.RowsItem

class ManualParsingImpl : DataApi {
    override fun getData(): Data {
        return Data(
            "some title",
            listOf(
                RowsItem(
                    "",
                    "some description",
                    "some row title"
                )
            )
        )
    }
}