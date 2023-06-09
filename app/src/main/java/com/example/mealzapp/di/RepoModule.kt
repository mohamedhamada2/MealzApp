package com.example.mealzapp.di

import com.example.data.remote.ApiService
import com.example.data.repo.MealsRepoImp
import com.example.domain.repo.MealsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Provides
    @Singleton
    fun provideRepo(apiService: ApiService): MealsRepo{
        return MealsRepoImp(apiService)
    }
}