package com.example.domain.repo

import com.example.domain.entity.CategoryResponse
import io.reactivex.rxjava3.core.Single

interface MealsRepo {
     fun get_meals_from_api(): Single<CategoryResponse>
}