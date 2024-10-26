package com.example.amv_supers_2024.feature.supers.presentation

import android.content.Context
import com.example.amv_supers_2024.feature.supers.data.SuperHeroDataRepository
import com.example.amv_supers_2024.feature.supers.data.local.SuperHeroXmlLocalDataSource
import com.example.amv_supers_2024.feature.supers.data.remote.SuperHeroMockRemoteDataSource
import com.example.amv_supers_2024.feature.supers.domain.model.GetSuperHeroListUseCase
import com.example.amv_supers_2024.feature.supers.domain.model.GetSuperHeroUseCase

class SuperHeroFactory(private val context: Context) {
    private val localDataSource = SuperHeroXmlLocalDataSource(context)
    private val remoteDataSource = SuperHeroMockRemoteDataSource()
    private val superHeroDataRepository = SuperHeroDataRepository(localDataSource, remoteDataSource)
    private val getSuperHeroListUseCase = GetSuperHeroListUseCase(superHeroDataRepository)
    private val getSuperHeroUseCase = GetSuperHeroUseCase(superHeroDataRepository)


    fun buildSuperHeroListViewModel(): SuperHeroListViewModel {
        return SuperHeroListViewModel(getSuperHeroListUseCase)
    }

    fun buildSuperHeroDetailViewModel(): SuperHeroDetailViewModel {
        return SuperHeroDetailViewModel(getSuperHeroUseCase)
    }

}