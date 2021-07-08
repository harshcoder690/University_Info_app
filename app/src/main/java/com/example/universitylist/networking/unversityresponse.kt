package com.example.universitylist

data class UnversityresponseItem(
	val domains: List<String?>? = null,
	val webPages: List<String?>? = null,
	val name: String? = null,
	val alphaTwoCode: String? = null,
	val stateprovince: String? = null,
	val country: String? = null,
)

data class Unversityresponse(
	val unversityresponse: List<UnversityresponseItem?>? = null
)

