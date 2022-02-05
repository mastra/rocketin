package com.molol.rocketin

import androidx.lifecycle.viewmodel.compose.viewModel
import com.molol.rocketin.data.BarListRepositoryImpl
import com.molol.rocketin.data.BarRepositoryImpl
import com.molol.rocketin.data.api.ApiService
import com.molol.rocketin.model.repository.BarRepository
import com.molol.rocketin.screen.DetailScreen
import com.molol.rocketin.viewmodel.DetailViewModel
import com.molol.rocketin.viewmodel.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val                                                                                                                                                     barModule = module {
    single { ApiService.getService() }
    //single<BarRepository> {  BarRepositoryImpl( get()) }
    single<BarRepository> {  BarListRepositoryImpl( ) }
    viewModel { ListViewModel( get() ) }
    viewModel { DetailViewModel(  ) }

}