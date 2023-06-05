package com.example.data.remote

import com.example.domain.entity.CategoryResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface ApiService {
    @GET("categories.php")
    fun get_meals(): Single<CategoryResponse>

}