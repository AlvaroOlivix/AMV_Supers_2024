package com.example.amv_supers_2024.feature.supers.data.local

import android.content.Context
import com.example.amv_supers_2024.R
import com.example.amv_supers_2024.feature.supers.domain.model.SuperHero
import com.google.gson.Gson

class SuperHeroXmlLocalDataSource(private val context: Context) {

    private val sharedPref = context.getSharedPreferences(
        context.getString(R.string.file_supersList_local),
        Context.MODE_PRIVATE
    )
    private val gson = Gson()

    fun saveSuperHero(superhero: SuperHero) {
        val editor = sharedPref.edit()
        //Serializamos el objeto SuperHero en formato JSON
        editor.putString(superhero.id, gson.toJson(superhero))
        editor.apply()
    }

    fun saveAll(superheroes: List<SuperHero>) {
        val editor = sharedPref.edit()
        //Por cada superheroe, lo serializamos y lo guardamos en el archivo
        superheroes.forEach { superhero ->
            //
            editor.putString(superhero.id, gson.toJson(superhero))
        }
        editor.apply()
    }

    fun findById(superheroId: String): SuperHero? {
        return sharedPref.getString(superheroId, null)?.let {
            gson.fromJson(it, SuperHero::class.java)
        }

    }

    fun findAll(): List<SuperHero> {
        val superheroes = mutableListOf<SuperHero>()
        sharedPref.all.forEach { entry ->
            superheroes.add(gson.fromJson(entry.value as String, SuperHero::class.java))
        }
        return superheroes

    }

    fun delete() {
        sharedPref.edit().clear().apply()
    }

    fun delete(superheroId: String) {
        sharedPref.edit().remove(superheroId).apply()
    }

}