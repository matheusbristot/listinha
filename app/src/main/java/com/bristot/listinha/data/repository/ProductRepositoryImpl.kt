package com.bristot.listinha.data.repository

import com.bristot.listinha.data.mapper.ProductMapper
import com.bristot.listinha.data.model.ResourceResult
import com.bristot.listinha.data.network.NetworkService
import com.bristot.listinha.data.service.ProductsService
import com.bristot.listinha.domain.model.Product
import com.bristot.listinha.domain.products.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

private const val DUMMY_DEVICE_OFFLINE = "Device offline"
private const val DUMMY_GENERIC_ERROR = "Generic error"
private const val DUMMY_HTTP_400 = 400
private const val DUMMY_HTTP_599 = 599

internal class ProductRepositoryImpl @Inject constructor(
    private val productsService: ProductsService,
    private val networkService: NetworkService,
    private val mapper: ProductMapper
) : ProductRepository {

    override suspend fun getProducts(): Flow<ResourceResult<List<Product>>> {
        return flow {
            try {
                getProducts()
            } catch (e: Exception) {
                emit(ResourceResult.Error(DUMMY_GENERIC_ERROR))
            }
        }
    }

    private suspend fun FlowCollector<ResourceResult<List<Product>>>.getProducts() {
        if (networkService.isConnected()) {
            get()
        } else {
            emit(ResourceResult.Error(DUMMY_DEVICE_OFFLINE))
        }
    }

    private suspend fun FlowCollector<ResourceResult<List<Product>>>.get() {
        val response = productsService.getProducts()
        when {
            response.isSuccessful && response.body() != null -> emit(
                ResourceResult.Success(mapper(response.body()))
            )
            response.code() in DUMMY_HTTP_400..DUMMY_HTTP_599 -> emit(
                ResourceResult.Error(response.message())
            )
            else -> emit(ResourceResult.Error(DUMMY_GENERIC_ERROR))
        }
    }
}