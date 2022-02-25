package com.example.android3lesson2.ui.fragments.words_fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.example.android3lesson2.adapters.WordAdapter;
import com.example.android3lesson2.base.BaseFragment;
import com.example.android3lesson2.databinding.FragmentWordsBinding;
import com.example.android3lesson2.viewmodel.PixabayViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class WordsFragment extends BaseFragment<FragmentWordsBinding> {

    PixabayViewModel viewModel;
    WordAdapter wordAdapter;
    WordsFragmentArgs args;

    @Override
    public FragmentWordsBinding bind() {
        return FragmentWordsBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(PixabayViewModel.class);
        getArgs();
        initListeners();
        initObserver();

    }

    private void initObserver() {
        String category = args.getFromCategoryToWords();
        viewModel.getWords(category).observe(getViewLifecycleOwner(), wordModels -> {
            if (wordModels != null) {
                wordAdapter = new WordAdapter(wordModels);
                binding.recyclerview.setAdapter(wordAdapter);

            }

        });
    }

    private void getArgs() {
        if (getArguments() != null) {
            WordsFragmentArgs.fromBundle(getArguments());
            String category = args.getFromCategoryToWords();
            binding.toolbar.setTitle(category);

        }
    }


    private void initListeners() {

        binding.btnAddWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateWordBottomSheetFragment createWordBottomSheetFragment = new CreateWordBottomSheetFragment();
                createWordBottomSheetFragment.show(requireActivity().getSupportFragmentManager(), "word dialog opened");

            }
        });


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}