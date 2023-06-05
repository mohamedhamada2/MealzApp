package com.example.mealzapp.di

import com.example.domain.repo.MealsRepo
import com.example.domain.usecase.GetMealz
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideUseCase(mealsRepo: MealsRepo):GetMealz{
        return GetMealz(mealsRepo)
    }
}