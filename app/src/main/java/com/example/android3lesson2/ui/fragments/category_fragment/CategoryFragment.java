package com.example.android3lesson2.ui.fragments.category_fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.android3lesson2.adapters.CategoryAdapter;
import com.example.android3lesson2.base.BaseFragment;
import com.example.android3lesson2.databinding.FragmentCategoryBinding;
import com.example.android3lesson2.utils.interfaces.OnCategoryClickListener;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class CategoryFragment extends BaseFragment<FragmentCategoryBinding> {
    private CategoryViewModel viewModel;
    private CategoryAdapter categoryAdapter;


    @Override
    public FragmentCategoryBinding bind() {
        return FragmentCategoryBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(CategoryViewModel.class);
        initListeners();
        initAdapter();
        initObserver();
    }

    private void initAdapter() {
        categoryAdapter = new CategoryAdapter();
    }


    private void initListeners() {
        binding.btnAddCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateCategoryBottomSheetFragment createCategoryBottomSheetFragment = new CreateCategoryBottomSheetFragment();
                createCategoryBottomSheetFragment.show(requireActivity().getSupportFragmentManager(), "category dialog opened");

            }
        });
        categoryAdapter.setOnCategoryClickListener(new OnCategoryClickListener() {
            @Override
            public void onClick(String category, int position) {
                Navigation.findNavController(requireView()).navigate(CategoryFragmentDirections.actionCategoryFragmentToWordsFragment(category, position));

            }
        });
    }

    private void initObserver() {
        viewModel.getCategories().observe(getViewLifecycleOwner(), categoryModels -> {
            if (categoryModels != null) {
                categoryAdapter.setList(categoryModels);
                binding.recyclerview.setAdapter(categoryAdapter);
            }


        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}