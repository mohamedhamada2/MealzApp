package com.example.mealzapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.entity.Category
import com.example.domain.entity.CategoryResponse
import com.example.mealzapp.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeFragment : Fragment() {
    lateinit var fragmentHomeBinding: FragmentHomeBinding
    private val mealsViewModel:MealsViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        mealsViewModel.get_meals()
        lifecycleScope.launch {
            try {
                mealsViewModel.mutableLiveData.observe(viewLifecycleOwner){
                    getcategories(it)
                }
            }catch (e:Exception){
               Log.e("e",e.message.toString())
            }
        }
        return fragmentHomeBinding.root
    }

    private fun getcategories(categoryResponse : CategoryResponse?) {
        val mealsAdapter = MealsAdapter(categoryList = categoryResponse!!.categories)
        val layoutManager = LinearLayoutManager(requireContext())
        fragmentHomeBinding.mealsRv.layoutManager = layoutManager
        fragmentHomeBinding.mealsRv.adapter = mealsAdapter
    }
}