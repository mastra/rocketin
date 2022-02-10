package com.molol.rocketin

import com.molol.rocketin.data.BarListRepositoryImpl
import com.molol.rocketin.model.repository.BarRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ViewModelModule {
    @Binds
    abstract fun bindsBarRepository( barRepositoryImpl: BarListRepositoryImpl)  : BarRepository

}