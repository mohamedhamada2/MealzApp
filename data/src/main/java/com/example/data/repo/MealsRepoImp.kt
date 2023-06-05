package com.example.data.repo

import com.example.data.remote.ApiService
import com.example.domain.entity.CategoryResponse
import com.example.domain.repo.MealsRepo

class MealsRepoImp(private val apiService: ApiService):MealsRepo {
    override suspend fun get_meals_from_api(): CategoryResponse = apiService.get_meals()

}