package com.molol.rocketin.data

import com.molol.rocketin.BuildConfig
import com.molol.rocketin.data.api.ApiService
import com.molol.rocketin.model.Bar
import com.molol.rocketin.model.repository.BarRepository

class BarRepositoryImpl(val apiService: ApiService) : BarRepository {
    override suspend fun search(query: String): List<Bar>? {
        val results = apiService.search(query)
        return results.body()?.results
    }

}