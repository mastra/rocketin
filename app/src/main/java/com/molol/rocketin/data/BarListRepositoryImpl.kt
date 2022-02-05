package com.molol.rocketin.data

import com.molol.rocketin.model.Bar
import com.molol.rocketin.model.repository.BarRepository

class BarListRepositoryImpl : BarRepository {
    override suspend fun search(query: String): List<Bar>? {
        return listOf( Bar("Bar Londres"), Bar("Caminito"), Bar("Duende verde"), Bar("Pony pisador"))
    }
}