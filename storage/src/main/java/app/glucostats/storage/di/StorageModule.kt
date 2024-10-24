package app.glucostats.storage.di

import android.content.Context
import app.glucostats.storage.data.local.PreferencesManager
import app.glucostats.storage.data.local.TokenStorage
import app.glucostats.storage.data.repository.TokenRepositoryImpl
import app.glucostats.storage.domain.repository.TokenRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object StorageModule {

    @Provides
    @Singleton
    fun providePreferencesManager(context: Context): PreferencesManager {
        return PreferencesManager(context)
    }

    @Provides
    @Singleton
    fun provideTokenStorage(preferencesManager: PreferencesManager): TokenStorage {
        return TokenStorage(preferencesManager)
    }

    @Provides
    @Singleton
    fun provideTokenRepository(tokenStorage: TokenStorage): TokenRepository {
        return TokenRepositoryImpl(tokenStorage)
    }
}