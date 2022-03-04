package com.example.android3lesson2.ui.fragments.words_fragment;

import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.android3lesson2.adapters.ImageAdapter;
import com.example.android3lesson2.data.local.room.models.WordModel;
import com.example.android3lesson2.databinding.FragmentCreateWordBottomSheetBinding;
import com.example.android3lesson2.network.responses.pixabay.PixabayHits;
import com.example.android3lesson2.utils.interfaces.OnImageClickListener;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class CreateWordBottomSheetFragment extends BottomSheetDialogFragment {
    WordsFragmentArgs args;
    WordsViewModel viewModel;
    Handler handler;
    ImageAdapter imageAdapter;
    String word;
    String category;
    int image;
    private FragmentCreateWordBottomSheetBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCreateWordBottomSheetBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(WordsViewModel.class);
        initListeners();
        initAdapter();
        getArgs();

    }

    private void getArgs() {
        if (getArguments() != null) {
            args = WordsFragmentArgs.fromBundle(getArguments());
            category = args.getStringFromDialogToWords();
        }
    }

    private void initAdapter() {
        imageAdapter = new ImageAdapter();
    }

    private void initListeners() {
        binding.btnWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WordModel wordModel = new WordModel(word, category, image);
                viewModel.insertWord(wordModel);
            }
        });
        binding.etWord.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (handler != null) {
                    handler = null;
                }


            }

            @Override
            public void afterTextChanged(Editable editable) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        word = binding.etWord.getText().toString();
                        viewModel.getImages(word).observe(getViewLifecycleOwner(), images -> {
                            if (images != null) {
                                binding.tvWord.setText(word);
                                imageAdapter.setApiData((ArrayList<PixabayHits>) images);
                                binding.recyclerview.setAdapter(imageAdapter);
                                imageAdapter.setOnImageClickListener(new OnImageClickListener() {
                                    @Override
                                    public void onClick(int position) {
                                        Navigation.findNavController(requireView()).navigate(CreateWordBottomSheetFragmentDirections.actionCreateWordBottomSheetFragmentToWordsFragment(word, position));
                                    }
                                });


                            }


                        });
                        viewModel.getTranslation(word).observe(getViewLifecycleOwner(), translatedWord -> {
                            if (translatedWord != null) {

                            }
                        });

                    }
                }, 2000);

            }


        });


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}