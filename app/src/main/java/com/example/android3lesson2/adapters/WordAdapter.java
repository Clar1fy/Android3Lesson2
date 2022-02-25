package com.example.android3lesson2.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android3lesson2.data.local.room.models.WordModel;
import com.example.android3lesson2.databinding.WordsHolderBinding;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordHolder> {
    List<WordModel> list = new ArrayList<>();


    public WordAdapter(List<WordModel> list) {
        this.list = list;

    }

    @NonNull
    @Override
    public WordAdapter.WordHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new WordHolder(WordsHolderBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull WordAdapter.WordHolder holder, int position) {
        holder.onBind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class WordHolder extends RecyclerView.ViewHolder {
        WordsHolderBinding binding;


        public WordHolder(@NonNull WordsHolderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(WordModel wordModel) {
            binding.tvWords.setText(wordModel.getWord());
            binding.imgWords.setImageResource(wordModel.getImage());

        }
    }
}
