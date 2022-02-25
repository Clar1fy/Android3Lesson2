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

import com.example.android3lesson2.adapters.ImageAdapter;
import com.example.android3lesson2.data.local.room.models.WordModel;
import com.example.android3lesson2.databinding.FragmentCreateWordBottomSheetBinding;
import com.example.android3lesson2.models.network_model.Hits;
import com.example.android3lesson2.utils.interfaces.OnImageClickListener;
import com.example.android3lesson2.viewmodel.PixabayViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;


public class CreateWordBottomSheetFragment extends BottomSheetDialogFragment implements OnImageClickListener {
    FragmentCreateWordBottomSheetBinding binding;
    WordsFragmentArgs args;
    PixabayViewModel viewModel;
    OnImageClickListener onImageClickListener;
    Handler handler;
    ImageAdapter imageAdapter;
    String word;
    String category;
    int image;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCreateWordBottomSheetBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(PixabayViewModel.class);
        initListeners();
        initAdapter();
        getArgs();

    }

    private void getArgs() {
        if (getArguments() != null) {
            args = WordsFragmentArgs.fromBundle(getArguments());
            category = args.getFromCategoryToWords();
        }
    }

    private void initAdapter() {
        imageAdapter = new ImageAdapter(this);
    }

    private void initListeners() {
        binding.btnWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                                        imageAdapter.setApiData((ArrayList<Hits>) images);
                                        binding.recyclerview.setAdapter(imageAdapter);
                                        WordModel wordModel = new WordModel(word, category, image);
                                        viewModel.insertWord(wordModel);


                                    }


                                });

                            }
                        }, 2000);

                    }


                });


            }
        });
    }


    @Override
    public void onClick(WordModel wordModel) {
        image = wordModel.getImage();


    }
}