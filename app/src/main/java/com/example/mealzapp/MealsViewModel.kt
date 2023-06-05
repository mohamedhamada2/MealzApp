package com.example.mealzapp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.domain.entity.CategoryResponse
import com.example.domain.usecase.GetMealz
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsViewModel @Inject constructor(private val getMealz: GetMealz) : ViewModel() {
    private val _categories = MutableStateFlow<CategoryResponse?>(null)
    val categories : StateFlow<CategoryResponse?> = _categories
    fun get_meals(){
        viewModelScope.launch {
         try {
             _categories.value = getMealz()
         }catch (e:Exception){
             Log.e("MealsViewModel",e.message.toString())
         }
        }
    }
}