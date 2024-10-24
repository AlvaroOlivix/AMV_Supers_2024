package com.example.amv_supers_2024.feature.supers.domain.model

class GetSuperHeroUseCase(private val repository: SuperHeroRepository) {
    operator fun invoke(id: String): SuperHero? {
        return repository.getSuperHero(id)
    }

}