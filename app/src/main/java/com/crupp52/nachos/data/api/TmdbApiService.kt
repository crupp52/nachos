package com.crupp52.nachos.data.api

import com.crupp52.nachos.data.db.entity.Movie
import com.crupp52.nachos.data.network.response.MovieCollectionResponse
import com.crupp52.nachos.utils.Constants
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbApiService {
    @GET("movie/{id}")
    fun getMovie(
        @Path("id") id: Int
    ): Deferred<Movie>

    @GET("trending/movie/week")
    fun getTrending(): Deferred<MovieCollectionResponse>

    @GET("discover/movie")
    fun getHighRated(
        @Query("sort_by") sortBy: String = "vote_average.desc"
    ): Deferred<MovieCollectionResponse>

    companion object {
        operator fun invoke(): TmdbApiService {
            val requestInterceptor = Interceptor { chain ->
                val url = chain
                    .request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("api_key", Constants.tmdbApiKey)
                    .build()

                val request = chain.request().newBuilder().url(url).build()

                return@Interceptor chain.proceed(request)
            }

            val httpClient = OkHttpClient.Builder().addInterceptor(requestInterceptor).build()

            return Retrofit
                .Builder()
                .client(httpClient)
                .baseUrl("https://api.themoviedb.org/3/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TmdbApiService::class.java)
        }
    }
}