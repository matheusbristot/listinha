package com.bristot.listinha.domain.products

import com.bristot.listinha.data.model.product.ResourceResult
import com.bristot.listinha.domain.model.product.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun getProducts(): Flow<ResourceResult<List<Product>>>
}
