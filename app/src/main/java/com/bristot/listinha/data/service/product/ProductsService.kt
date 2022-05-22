package com.bristot.listinha.data.service.product

import com.bristot.listinha.data.model.product.ProductResponse
import retrofit2.Response
import retrofit2.http.GET

interface ProductsService {

    @GET("products/")
    suspend fun getProducts(): Response<List<ProductResponse>>
}
