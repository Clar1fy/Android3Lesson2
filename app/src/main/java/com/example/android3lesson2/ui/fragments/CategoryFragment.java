package com.example.android3lesson2.ui.fragments;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.android3lesson2.adapters.CategoryAdapter;
import com.example.android3lesson2.base.BaseFragment;
import com.example.android3lesson2.databinding.FragmentCategoryBinding;
import com.example.android3lesson2.ui.fragments.dialog.CreateCategoryBottomSheetFragment;
import com.example.android3lesson2.utils.interfaces.OnCategoryClickListener;
import com.example.android3lesson2.viewmodel.PixabayViewModel;


public class CategoryFragment extends BaseFragment<FragmentCategoryBinding> implements OnCategoryClickListener {
    PixabayViewModel viewModel;
    CategoryAdapter categoryAdapter;


    @Override
    public FragmentCategoryBinding bind() {
        return FragmentCategoryBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(PixabayViewModel.class);
        initListeners();
        initObserver();
    }


    private void initListeners() {
        binding.btnAddCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateCategoryBottomSheetFragment createCategoryBottomSheetFragment = new CreateCategoryBottomSheetFragment();
                createCategoryBottomSheetFragment.show(requireActivity().getSupportFragmentManager(), "category dialog opened");

            }
        });
    }

    private void initObserver() {
        viewModel.getCategories().observe(getViewLifecycleOwner(), categoryModels -> {
            if (categoryModels != null) {
                categoryAdapter = new CategoryAdapter(this, categoryModels);
                binding.recyclerview.setAdapter(categoryAdapter);
            }


        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(String category) {
        CategoryFragmentDirections.ActionCategoryFragmentToWordsFragment action
                = CategoryFragmentDirections.actionCategoryFragmentToWordsFragment(category);
        Navigation.findNavController(requireView()).navigate(action);

    }
}