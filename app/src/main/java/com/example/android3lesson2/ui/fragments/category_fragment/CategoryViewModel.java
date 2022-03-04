package com.example.android3lesson2.ui.fragments.category_fragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.android3lesson2.data.local.RoomHelper;
import com.example.android3lesson2.data.local.room.models.CategoryModel;
import com.example.android3lesson2.repository.PixabayRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class CategoryViewModel extends ViewModel {
    RoomHelper roomHelper;
    PixabayRepository repository;
    private MutableLiveData<List<CategoryModel>> categoryList = new MutableLiveData<>();

    @Inject
    public CategoryViewModel(RoomHelper roomHelper, PixabayRepository repository) {
        this.roomHelper = roomHelper;
        this.repository = repository;
    }

    public void insertCategory(CategoryModel categoryModel) {
        roomHelper.insertCategory(categoryModel);
    }

    public LiveData<List<CategoryModel>> getCategories() {
        return categoryList = repository.getCategories();
    }
}
