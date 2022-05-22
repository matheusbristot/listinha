package com.bristot.listinha.data.model.product

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class ProductResponse(
    @SerialName(value = "id") val id: String? = null,
    @SerialName(value = "name") val name: String? = null,
    @SerialName(value = "avatar") val avatar: String? = null,
    @SerialName(value = "price") val price: String? = null,
    @SerialName(value = "createdAt") val createdAt: String? = null
)
