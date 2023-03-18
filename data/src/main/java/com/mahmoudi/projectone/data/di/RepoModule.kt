package com.mahmoudi.projectone.data.di

import com.mahmoudi.projectone.data.api.ProjectApi
import com.mahmoudi.projectone.data.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideRepo(projectApi: ProjectApi): Repository {
        return Repository(projectApi)

    }
}