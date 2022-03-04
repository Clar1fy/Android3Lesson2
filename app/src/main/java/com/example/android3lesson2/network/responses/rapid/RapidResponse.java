package com.example.android3lesson2.network.responses.rapid;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RapidResponse {
    @SerializedName("translatedText")
    private String translatedText;
    @SerializedName("match")
    private List<RapidHits> match = null;

    public String getTranslatedText() {
        return translatedText;
    }

    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }

    public List<RapidHits> getMatch() {
        return match;
    }

    public void setMatch(List<RapidHits> match) {
        this.match = match;
    }
}
