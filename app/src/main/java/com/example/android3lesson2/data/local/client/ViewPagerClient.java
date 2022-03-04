package com.example.android3lesson2.data.local.client;

import com.example.android3lesson2.R;
import com.example.android3lesson2.model.ViewPagerModel;

import java.util.ArrayList;

public class ViewPagerClient {
    public ArrayList<ViewPagerModel> list = new ArrayList<>();

    public ArrayList<ViewPagerModel> getList() {
        list.add(new ViewPagerModel("Categories", "Create your own categories for words", R.drawable.ic_first_board_fragment));
        list.add(new ViewPagerModel("Words", "Create words in English and click on the card to see the translation and image for associations", R.drawable.ic_second_board_fragment));
        list.add(new ViewPagerModel("Learning", "Swipe the card either to the right if you remembered it or to the left if you don't", R.drawable.ic_third_board_fragment));
        list.add(new ViewPagerModel("Your profile", "Track your achievements and experience", R.drawable.ic_fourth_board_fragment));
        list.add(new ViewPagerModel("Let's get started!", "Let's do it!", R.drawable.ic_fifth_board_fragment));
        return list;

    }
}
