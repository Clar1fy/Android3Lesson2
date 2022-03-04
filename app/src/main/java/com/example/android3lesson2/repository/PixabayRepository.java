package com.example.android3lesson2.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.android3lesson2.data.local.room.database.AppDatabase;
import com.example.android3lesson2.data.local.room.models.CategoryModel;
import com.example.android3lesson2.data.local.room.models.WordModel;
import com.example.android3lesson2.network.apis.PixabayApi;
import com.example.android3lesson2.network.apis.RapidApi;
import com.example.android3lesson2.network.responses.pixabay.PixabayHits;
import com.example.android3lesson2.network.responses.pixabay.PixabayResponse;
import com.example.android3lesson2.network.responses.rapid.RapidHits;
import com.example.android3lesson2.network.responses.rapid.RapidResponse;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PixabayRepository {
    public static PixabayRepository pixabayRepository;
    AppDatabase appDatabase;
    PixabayApi pixabayApi;
    RapidApi rapidApi;

    @Inject
    public PixabayRepository(PixabayApi pixabayApi, RapidApi rapidApi) {
        this.pixabayApi = pixabayApi;
        this.rapidApi = rapidApi;
    }

    public MutableLiveData<List<PixabayHits>> getImages(String word) {
        MutableLiveData<List<PixabayHits>> imagesList = new MutableLiveData<>();

        pixabayApi.getImages(word).enqueue(new Callback<PixabayResponse>() {
            @Override
            public void onResponse(Call<PixabayResponse> call, Response<PixabayResponse> response) {
                if (response.isSuccessful()) {
                    imagesList.postValue(response.body().getHits());

                }

            }

            @Override
            public void onFailure(Call<PixabayResponse> call, Throwable t) {

            }
        });
        return imagesList;


    }

    public MutableLiveData<List<RapidHits>> getTranslation(String word) {
        MutableLiveData<List<RapidHits>> translationsList = new MutableLiveData<>();

        rapidApi.getTranslation(word, 1, 0, "translated-mymemory---translation-memory.p.rapidapi.com", "7fdf0c3215msh6a008d2bac47dfep1d5367jsne7b94b60412b").enqueue(new Callback<RapidResponse>() {
            @Override
            public void onResponse(Call<RapidResponse> call, Response<RapidResponse> response) {
                if (response.isSuccessful()) {
                    translationsList.postValue(response.body().getMatch());


                }
            }

            @Override
            public void onFailure(Call<RapidResponse> call, Throwable t) {

            }
        });
        return translationsList;
    }

    public MutableLiveData<List<CategoryModel>> getCategories() {
        MutableLiveData<List<CategoryModel>> categoryList = new MutableLiveData<>();
        categoryList.setValue((List<CategoryModel>) appDatabase.getDatabase().categoryDao().getAll());
        return categoryList;
    }

    public MutableLiveData<List<WordModel>> getWords(String userCategory) {
        MutableLiveData<List<WordModel>> wordsList = new MutableLiveData<>();
        wordsList.setValue((List<WordModel>) appDatabase.getDatabase().wordDao().getAll(userCategory));
        return wordsList;
    }

}
