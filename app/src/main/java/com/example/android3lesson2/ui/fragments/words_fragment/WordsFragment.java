package com.example.android3lesson2.ui.fragments.words_fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.example.android3lesson2.adapters.WordAdapter;
import com.example.android3lesson2.base.BaseFragment;
import com.example.android3lesson2.databinding.FragmentWordsBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class WordsFragment extends BaseFragment<FragmentWordsBinding> {

    WordsViewModel viewModel;
    WordAdapter wordAdapter;
    WordsFragmentArgs args;
    String category;

    @Override
    public FragmentWordsBinding bind() {
        return FragmentWordsBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(WordsViewModel.class);
        getArgs();
        initListeners();
        initObserver();

    }

    private void initObserver() {
        category = args.getStringFromDialogToWords();
        viewModel.getWords(category).observe(getViewLifecycleOwner(), wordModels -> {
            if (wordModels != null) {
                wordAdapter = new WordAdapter(wordModels);
                binding.recyclerview.setAdapter(wordAdapter);

            }

        });
    }

    private void getArgs() {
        if (getArguments() != null) {
            WordsFragmentArgs.fromBundle(getArguments()).getStringFromDialogToWords();
            category = args.getStringFromDialogToWords();
            binding.toolbar.setTitle(category);

        }
    }


    private void initListeners() {
        binding.btnAddWord.setOnClickListener(view -> {
            CreateWordBottomSheetFragment createWordBottomSheetFragment = new CreateWordBottomSheetFragment();
            createWordBottomSheetFragment.show(requireActivity().getSupportFragmentManager(), "word dialog opened");

        });


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}