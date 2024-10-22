package app.glucostats.di

import app.glucostats.dexcom.api.Dexcom
import app.glucostats.dexcom.impl.DexcomImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class GlucostatsModule {

    @Provides
    @Singleton
    fun providesDexcom(): Dexcom = DexcomImpl()

}