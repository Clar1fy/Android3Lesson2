package com.example.android3lesson2.di;

import com.example.android3lesson2.data.local.PreferencesHelper;
import com.example.android3lesson2.data.local.RoomHelper;
import com.example.android3lesson2.network.PixabayApi;
import com.example.android3lesson2.repository.PixabayRepository;
import com.example.android3lesson2.viewmodel.PixabayViewModel;

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
public class AppModule {
    @Singleton
    @Provides

    public static PixabayRepository provideRepository(PixabayApi api) {
        return new PixabayRepository(api);

    }

    @Singleton
    @Provides

    public static PixabayViewModel provideViewModel(PixabayRepository repository, PreferencesHelper preferencesHelper, RoomHelper roomHelper) {
        return new PixabayViewModel(repository, preferencesHelper, roomHelper);
    }

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
