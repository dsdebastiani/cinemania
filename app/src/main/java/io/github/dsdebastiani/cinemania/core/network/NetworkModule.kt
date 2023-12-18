package io.github.dsdebastiani.cinemania.core.network

import android.content.Context
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.github.dsdebastiani.cinemania.BuildConfig
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.OkHttpClient.Builder
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "https://api.themoviedb.org/3/"
    private const val CACHE_SIZE: Long = 5 * 1024 * 1024

    @Singleton
    @Provides
    fun provideCache(
        @ApplicationContext applicationContext: Context
    ): Cache = Cache(applicationContext.cacheDir, CACHE_SIZE)

    @Singleton
    @Provides
    fun provideAuthenticator() = TokenAuthenticator(BuildConfig.TMDB_API_KEY)

    @Singleton
    @Provides
    fun provideOkhttpClient(
        cache: Cache,
        authenticator: TokenAuthenticator
    ): OkHttpClient = Builder()
        .cache(cache)
        .authenticator(authenticator)
        .build()

    @Singleton
    @Provides
    fun provideMoshiConverter(): Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        moshi: Moshi
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    @Singleton
    @Provides
    fun provideApiService(
        retrofit: Retrofit
    ) : TMDBServiceApi = retrofit.create(TMDBServiceApi::class.java)
}
