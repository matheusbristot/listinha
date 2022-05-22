package com.bristot.listinha.data.mapper

import com.bristot.listinha.data.model.ProductResponse
import com.bristot.listinha.domain.model.Product

interface ProductMapper {
    operator fun invoke(productsResponse: List<ProductResponse>?): List<Product>
}
