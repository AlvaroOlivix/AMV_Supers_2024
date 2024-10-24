package com.example.amv_supers_2024.feature.supers.domain.model

class GetSuperHeroListUseCase (private val repository: SuperHeroRepository){

    operator fun invoke(): List<SuperHero> {

        return repository.getSuperHeroes()
    }
}