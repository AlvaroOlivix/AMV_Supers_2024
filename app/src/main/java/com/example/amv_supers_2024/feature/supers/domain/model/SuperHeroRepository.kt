package com.example.amv_supers_2024.feature.supers.domain.model

interface SuperHeroRepository {
    fun getSuperHeroes(): List<SuperHero>
    fun getSuperHero(id: String): SuperHero?

}