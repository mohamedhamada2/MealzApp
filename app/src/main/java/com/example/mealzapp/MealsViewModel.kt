package com.example.mealzapp

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.domain.entity.CategoryResponse
import com.example.domain.usecase.GetMealz
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsViewModel @Inject constructor(private val getMealz: GetMealz) : ViewModel() {
    /*private val _categories = MutableStateFlow<CategoryResponse?>(null)
    val categories : StateFlow<CategoryResponse?> = _categories*/
    lateinit var single : Single<CategoryResponse>
    val mutableLiveData :MutableLiveData<CategoryResponse?> = MutableLiveData<CategoryResponse?>()
    private fun setData(categoryresponse: CategoryResponse) {
        mutableLiveData.value =categoryresponse
    }

    private fun setError(e: Throwable) {
        Log.e("error",e.message.toString())
    }

    @SuppressLint("CheckResult")
    fun get_meals(){
        single = getMealz.invoke().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        single.subscribe({category:CategoryResponse -> setData(category)},{e:Throwable-> setError(e)})


    }
}