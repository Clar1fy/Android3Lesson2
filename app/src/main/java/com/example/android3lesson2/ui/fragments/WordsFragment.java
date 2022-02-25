package com.example.android3lesson2.ui.fragments;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.example.android3lesson2.adapters.WordAdapter;
import com.example.android3lesson2.base.BaseFragment;
import com.example.android3lesson2.databinding.FragmentWordsBinding;
import com.example.android3lesson2.ui.fragments.dialog.CreateWordBottomSheetFragment;
import com.example.android3lesson2.utils.interfaces.OnWordClickListener;
import com.example.android3lesson2.viewmodel.PixabayViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class WordsFragment extends BaseFragment<FragmentWordsBinding> implements OnWordClickListener {
    PixabayViewModel viewModel;
    WordAdapter wordAdapter;
    CategoryFragmentArgs args;

    @Override
    public FragmentWordsBinding bind() {
        return FragmentWordsBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(PixabayViewModel.class);
        initAdapter();
        getArgs();
        initListeners();
        initObserver();

    }

    private void initObserver() {
        String category = args.getArgsFromCategoryToWords();
        viewModel.getWords(category).observe(getViewLifecycleOwner(), wordModels -> {
            if (wordModels != null) {
                wordAdapter = new WordAdapter(wordModels, this);
                binding.recyclerview.setAdapter(wordAdapter);
            }

        });
    }

    private void getArgs() {
        if (getArguments() != null) {
            args = CategoryFragmentArgs.fromBundle(getArguments());
            String category = args.getArgsFromCategoryToWords();
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

    private void initAdapter() {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}