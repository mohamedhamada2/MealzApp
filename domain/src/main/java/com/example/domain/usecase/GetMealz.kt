package com.example.domain.usecase

import com.example.domain.repo.MealsRepo

class GetMealz(private val mealsRepo: MealsRepo) {
    suspend operator fun invoke() = mealsRepo.get_meals_from_api()
}