package com.bristot.listinha.data.mapper.product

import com.bristot.listinha.data.model.product.ProductResponse
import com.bristot.listinha.domain.model.product.Product

interface ProductMapper {
    operator fun invoke(productsResponse: List<ProductResponse>?): List<Product>
}
