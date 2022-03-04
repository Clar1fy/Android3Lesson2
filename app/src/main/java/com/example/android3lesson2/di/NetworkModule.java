package com.example.android3lesson2.di;

import com.example.android3lesson2.network.apis.PixabayApi;
import com.example.android3lesson2.network.apis.RapidApi;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class NetworkModule {
    @Singleton
    @Provides
    public static PixabayApi providePixabay(OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl("https://pixabay.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build().create(PixabayApi.class);

    }

    @Singleton
    @Provides
    public static RapidApi provideRapidApi(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl("https://translated-mymemory---translation-memory.p.rapidapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build().create(RapidApi.class);
    }

    @Singleton
    @Provides

    public OkHttpClient provideOkHttpClient(Interceptor interceptor) {
        return new OkHttpClient().newBuilder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();


    }

    @Singleton
    @Provides
    public Interceptor provideLoggingInterceptor() {
        return new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);
    }
}
