package com.bristot.listinha.data.mapper

import com.bristot.listinha.data.model.ProductResponse
import com.bristot.listinha.domain.model.Product
import javax.inject.Inject

class ProductMapperImpl @Inject constructor() : ProductMapper {

    override fun invoke(productsResponse: List<ProductResponse>?): List<Product> {
        return productsResponse?.map { mapper(it) } ?: emptyList()
    }

    private fun mapper(productResponse: ProductResponse): Product {
        return Product(
            id = productResponse.id.orEmpty(),
            name = productResponse.name.orEmpty(),
            avatar = productResponse.avatar.orEmpty(),
            price = productResponse.price.orEmpty(),
            createdAt = productResponse.createdAt.orEmpty()
        )
    }
}