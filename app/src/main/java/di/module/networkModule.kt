package di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import retrofit.ApiServices
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(Singleton::class)
class networkModule {
    @Provides
    @Singleton
    fun providesRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }
    @Provides
    @Singleton
    fun providesApiServices(retrofit : Retrofit) = retrofit.create(ApiServices::class.java)
}