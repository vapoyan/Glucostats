package app.glucostats.dexcom.di

import app.glucostats.dexcom.data.api.Dexcom
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DexcomModule {

    @Provides
    @Singleton
    fun provideDexcomApi(retrofit: Retrofit): Dexcom {
        return retrofit.create(Dexcom::class.java)
    }
}