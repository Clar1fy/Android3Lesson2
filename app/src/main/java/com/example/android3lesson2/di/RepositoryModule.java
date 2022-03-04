package com.example.android3lesson2.di;

import com.example.android3lesson2.network.apis.PixabayApi;
import com.example.android3lesson2.network.apis.RapidApi;
import com.example.android3lesson2.repository.PixabayRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class RepositoryModule {
    @Singleton
    @Provides
    public static PixabayRepository provideRepository(PixabayApi pixabayApi, RapidApi rapidApi) {
        return new PixabayRepository(pixabayApi, rapidApi);

    }
}
