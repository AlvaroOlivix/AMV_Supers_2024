package com.example.amv_supers_2024.feature.supers.presentation

import androidx.lifecycle.ViewModel
import com.example.amv_supers_2024.feature.supers.domain.model.GetSuperHeroListUseCase
import com.example.amv_supers_2024.feature.supers.domain.model.SuperHeroRepository

class SuperHeroListViewModel(
    private val getSuperHeroListUseCase: GetSuperHeroListUseCase
) : ViewModel() {


}