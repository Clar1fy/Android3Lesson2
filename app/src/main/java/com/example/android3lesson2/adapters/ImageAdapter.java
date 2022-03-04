package com.example.android3lesson2.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.android3lesson2.databinding.ImageHolderBinding;
import com.example.android3lesson2.network.responses.pixabay.PixabayHits;
import com.example.android3lesson2.utils.interfaces.OnImageClickListener;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewholder> {
    List<PixabayHits> list = new ArrayList<>();
    OnImageClickListener onImageClickListener;

    public void setOnImageClickListener(OnImageClickListener onImageClickListener) {
        this.onImageClickListener = onImageClickListener;
    }

    @NonNull
    @Override
    public ImageViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ImageViewholder(ImageHolderBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapter.ImageViewholder holder, int position) {
        holder.onBind(list.get(position));


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setApiData(List<PixabayHits> list) {
        this.list = list;
    }

    public class ImageViewholder extends RecyclerView.ViewHolder {
        ImageHolderBinding binding;

        public ImageViewholder(@NonNull ImageHolderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(PixabayHits pixabayResponse) {
            Glide.with(binding.imImage).load(pixabayResponse.getLargeImageURL()).into(binding.imImage);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onImageClickListener.onClick(getAdapterPosition());

                }
            });


        }


    }
}
