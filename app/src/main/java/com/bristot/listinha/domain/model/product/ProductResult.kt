package com.bristot.listinha.domain.model.product

sealed interface ProductResult {
    object Empty : ProductResult
    data class Success(val products: List<Product>) : ProductResult
    data class Error(val message: String) : ProductResult
}