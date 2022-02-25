package com.example.android3lesson2.adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android3lesson2.data.local.room.models.WordModel;
import com.example.android3lesson2.utils.interfaces.OnWordClickListener;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordHolder> {
    List<WordModel> list = new ArrayList<>();
    OnWordClickListener onWordClickListener;

    public WordAdapter(List<WordModel> list, OnWordClickListener onWordClickListener) {
        this.list = list;
        this.onWordClickListener = onWordClickListener;
    }

    @NonNull
    @Override
    public WordAdapter.WordHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


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


        public WordHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void onBind(WordModel wordModel) {
        }
    }
}
