package com.bristot.listinha.domain.products

import com.bristot.listinha.data.model.product.ResourceResult
import com.bristot.listinha.domain.model.product.Product
import com.bristot.listinha.domain.model.product.ProductResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

internal class GetProductsUseCaseImpl @Inject constructor(
    private val repository: ProductRepository
) : GetProductsUseCase {

    override suspend operator fun invoke(): Flow<ProductResult> {
        return flow {
            try {
                repository.getProducts().collect { result ->
                    if (result is ResourceResult.Error) emit(ProductResult.Error(result.message.orEmpty()))
                    else if (result is ResourceResult.Success) unwrapSuccess(result.data)
                }
            } catch (e: Exception) {
                emit(ProductResult.Error(e.message.orEmpty()))
            }
        }
    }

    private suspend fun FlowCollector<ProductResult>.unwrapSuccess(result: List<Product>?) {
        result?.let { products ->
            if (products.isEmpty()) {
                emit(ProductResult.Empty)
            } else {
                emit(ProductResult.Success(products))
            }
        } ?: emit(ProductResult.Empty)
    }
}
