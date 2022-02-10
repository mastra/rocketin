package com.molol.rocketin.data

import com.molol.rocketin.data.api.ApiService
import com.molol.rocketin.model.repository.BarRepository
import javax.inject.Inject

class BarRepositoryImpl @Inject constructor(val apiService: ApiService) : BarRepository {
    override suspend fun search(query: String) = apiService.search(query).body()?.results
}