package com.example.amv_supers_2024.feature.supers.presentation

import androidx.lifecycle.ViewModel
import com.example.amv_supers_2024.feature.supers.domain.model.GetSuperHeroUseCase

class SuperHeroDetailViewModel(
    private val getSuperHeroUseCase: GetSuperHeroUseCase
) : ViewModel() {
}