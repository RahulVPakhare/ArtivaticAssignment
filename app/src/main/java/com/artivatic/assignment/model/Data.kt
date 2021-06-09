package com.artivatic.assignment.model

data class Data(
	val title: String? = null,
	val rows: List<RowsItem?>? = null
)

data class RowsItem(
	val imageHref: String? = null,
	val description: String? = null,
	val title: String? = null
)

