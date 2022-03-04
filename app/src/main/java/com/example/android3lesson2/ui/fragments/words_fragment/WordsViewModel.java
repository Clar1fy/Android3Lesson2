package com.example.android3lesson2.ui.fragments.words_fragment;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.android3lesson2.data.local.RoomHelper;
import com.example.android3lesson2.data.local.room.models.WordModel;
import com.example.android3lesson2.network.responses.pixabay.PixabayHits;
import com.example.android3lesson2.network.responses.rapid.RapidHits;
import com.example.android3lesson2.repository.PixabayRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class WordsViewModel extends ViewModel {
    RoomHelper roomHelper;
    PixabayRepository repository;
    private MutableLiveData<List<WordModel>> wordsList = new MutableLiveData<>();
    private MutableLiveData<List<PixabayHits>> imageList = new MutableLiveData<>();
    private MutableLiveData<List<RapidHits>> translationList = new MutableLiveData<>();


    @Inject
    public WordsViewModel(RoomHelper roomHelper, PixabayRepository repository) {
        this.roomHelper = roomHelper;
        this.repository = repository;
    }

    public MutableLiveData<List<PixabayHits>> getImages(String word) {
        imageList = repository.getImages(word);
        return imageList;
    }

    public MutableLiveData<List<RapidHits>> getTranslation(String word) {
        translationList = repository.getTranslation(word);
        return translationList;

    }


    public void insertWord(WordModel wordModel) {
        roomHelper.insertWord(wordModel);

    }

    public MutableLiveData<List<WordModel>> getWords(String userCategory) {
        return wordsList = repository.getWords(userCategory);
    }


}
