package com.molol.rocketin.model.repository

import com.molol.rocketin.model.Bar

interface BarRepository {
    suspend fun search( query:String) : List<Bar>?
}