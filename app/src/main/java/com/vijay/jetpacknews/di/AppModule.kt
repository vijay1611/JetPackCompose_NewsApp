package com.vijay.jetpacknews.di

import android.app.Application
import com.vijay.jetpacknews.Util.Constants.BASE_URL
import com.vijay.jetpacknews.data.manager.LocalUserManagerImpl
import com.vijay.jetpacknews.data.remote.dto.NewsApi
import com.vijay.jetpacknews.data.repository.NewsRepositoryImpl
import com.vijay.jetpacknews.domain.Repository.NewsRepository
import com.vijay.jetpacknews.domain.manager.LocalUserManager
import com.vijay.jetpacknews.domain.usecases.app_entry.AppEntryUseCases
import com.vijay.jetpacknews.domain.usecases.app_entry.ReadAppEntry
import com.vijay.jetpacknews.domain.usecases.app_entry.SaveAppEntry
import com.vijay.jetpacknews.domain.usecases.news.GetNews
import com.vijay.jetpacknews.domain.usecases.news.NewsUseCases
import com.vijay.jetpacknews.domain.usecases.news.SearchNews
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(application: Application):LocalUserManager=LocalUserManagerImpl(application)




    @Provides
    @Singleton
    fun providesAppEntryUseCases(
        localUserManager: LocalUserManager
    )= AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

    @Provides
    @Singleton
    fun provideNewsApi():NewsApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun providesNewsRepository(
        newsApi: NewsApi
    ):NewsRepository = NewsRepositoryImpl(newsApi)


    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository
    ):NewsUseCases{
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository)
        )

    }

}