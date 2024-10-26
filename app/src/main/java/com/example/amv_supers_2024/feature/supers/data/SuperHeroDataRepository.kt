package com.example.amv_supers_2024.feature.supers.data

import com.example.amv_supers_2024.feature.supers.data.local.SuperHeroXmlLocalDataSource
import com.example.amv_supers_2024.feature.supers.data.remote.SuperHeroMockRemoteDataSource
import com.example.amv_supers_2024.feature.supers.domain.model.SuperHero
import com.example.amv_supers_2024.feature.supers.domain.model.SuperHeroRepository

class SuperHeroDataRepository(
    private val localDataSource: SuperHeroXmlLocalDataSource,
    private val remoteDataSource: SuperHeroMockRemoteDataSource
) : SuperHeroRepository {


    override fun getSuperHeroes(): List<SuperHero> {
        val superheroesFromLocal = localDataSource.findAll()
        if (superheroesFromLocal.isEmpty()) {
            val superheroesFromRemote = remoteDataSource.getSuperList()
            localDataSource.saveAll(superheroesFromRemote)
            return superheroesFromRemote
        } else {
            return superheroesFromLocal
        }
    }

    override fun getSuperHero(id: String): SuperHero? {
        val superHeroFromLocal = localDataSource.findById(id)
        if (superHeroFromLocal == null) {
            remoteDataSource.getSuperHero(id)?.let {
                localDataSource.saveSuperHero(it)
                return it
            }
        }
        return superHeroFromLocal
    }
}