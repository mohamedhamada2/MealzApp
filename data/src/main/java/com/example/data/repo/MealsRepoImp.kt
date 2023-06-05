package com.example.data.repo

import com.example.data.remote.ApiService
import com.example.domain.entity.CategoryResponse
import com.example.domain.repo.MealsRepo
import io.reactivex.rxjava3.core.Single

class MealsRepoImp(private val apiService: ApiService):MealsRepo {
    override  fun get_meals_from_api(): Single<CategoryResponse> = apiService.get_meals()

}