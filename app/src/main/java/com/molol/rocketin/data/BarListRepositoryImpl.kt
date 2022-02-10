package com.molol.rocketin.data

import com.molol.rocketin.model.Bar
import com.molol.rocketin.model.repository.BarRepository
import javax.inject.Inject

class BarListRepositoryImpl @Inject constructor() : BarRepository {
    override suspend fun search(query: String): List<Bar>? {
        return listOf( Bar("Bar Londres"), Bar("Caminito"), Bar("Duende verde"), Bar("Pony pisador"))
    }
}