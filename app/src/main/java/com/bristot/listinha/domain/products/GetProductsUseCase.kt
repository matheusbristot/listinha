package com.bristot.listinha.domain.products

import com.bristot.listinha.domain.model.ProductResult
import kotlinx.coroutines.flow.Flow

interface GetProductsUseCase {
    suspend operator fun invoke(): Flow<ProductResult>
}