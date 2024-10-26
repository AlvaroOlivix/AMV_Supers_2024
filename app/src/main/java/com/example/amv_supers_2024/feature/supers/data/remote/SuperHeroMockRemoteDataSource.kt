package com.example.amv_supers_2024.feature.supers.data.remote

import com.example.amv_supers_2024.feature.supers.domain.model.SuperHero

class SuperHeroMockRemoteDataSource {

    private val superheroeList = listOf(
        SuperHero("1", "A-Bomb", "Desc1", "iamge1"),
        SuperHero("2", "SuperMan", "Desc2", "image2"),
        SuperHero("3", "DeadPool", "Desc3", "image3"),
        SuperHero("4", "Black Widow", "Desc4", "image4")
    )

    fun getSuperList(): List<SuperHero> {
        return superheroeList
    }

    fun getSuperHero(id: String): SuperHero? {
        return superheroeList.firstOrNull { it.id == id }
    }

}
