package com.example.android3lesson2.ui.fragments.category_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.example.android3lesson2.data.local.room.models.CategoryModel;
import com.example.android3lesson2.databinding.FragmentCreateCategoryBottomSheetBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class CreateCategoryBottomSheetFragment extends BottomSheetDialogFragment {
    private FragmentCreateCategoryBottomSheetBinding binding;
    private CategoryViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCreateCategoryBottomSheetBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListeners();
        viewModel = new ViewModelProvider(this).get(CategoryViewModel.class);
    }


    private void initListeners() {
        binding.btnCreateCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String category = binding.etCategory.getText().toString();
                CategoryModel categoryModel = new CategoryModel(category);
                viewModel.insertCategory(categoryModel);

            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
