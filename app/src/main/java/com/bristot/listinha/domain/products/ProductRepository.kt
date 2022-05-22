package com.bristot.listinha.domain.products

import com.bristot.listinha.data.model.ResourceResult
import com.bristot.listinha.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun getProducts(): Flow<ResourceResult<List<Product>>>
}
