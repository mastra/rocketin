package com.molol.rocketin

import com.molol.rocketin.data.BarRepositoryImpl
import com.molol.rocketin.data.api.ApiService
import com.molol.rocketin.model.repository.BarRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    fun providesApiService() : ApiService = ApiService.getService()

}