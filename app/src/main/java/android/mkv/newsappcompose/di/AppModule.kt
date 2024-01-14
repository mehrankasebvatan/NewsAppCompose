package android.mkv.newsappcompose.di

import android.app.Application
import android.mkv.newsappcompose.data.manager.LocalUserManagerImpl
import android.mkv.newsappcompose.domain.manager.LocalUserManager
import android.mkv.newsappcompose.domain.usecases.AppEntryUseCases
import android.mkv.newsappcompose.domain.usecases.ReadAppEntry
import android.mkv.newsappcompose.domain.usecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(application: Application):
            LocalUserManager = LocalUserManagerImpl(application)


    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )


}