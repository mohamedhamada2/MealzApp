package com.example.mealzapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mealzapp.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

@AndroidEntryPoint
class HomeFragment : Fragment() {
    lateinit var fragmentHomeBinding: FragmentHomeBinding
    lateinit var navController: NavController
    private val mealsViewModel:MealsViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        mealsViewModel.get_meals()
        val mealsAdapter = MealsAdapter()
        val layoutManager = LinearLayoutManager(requireContext())
        lifecycleScope.launch {
            mealsViewModel.categories.collect{
                mealsAdapter.submitList(it?.categories)
                fragmentHomeBinding.mealsRv.adapter = mealsAdapter
                fragmentHomeBinding.mealsRv.layoutManager = layoutManager
            }
        }
        return fragmentHomeBinding.root
    }
}