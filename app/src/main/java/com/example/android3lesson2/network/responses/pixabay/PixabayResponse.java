package com.example.android3lesson2.network.responses.pixabay;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PixabayResponse {
    @SerializedName("total")
    private Integer total;
    @SerializedName("totalHits")
    private Integer totalHits;
    @SerializedName("hits")
    private List<PixabayHits> hits = null;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(Integer totalHits) {
        this.totalHits = totalHits;
    }

    public List<PixabayHits> getHits() {
        return hits;
    }

    public void setHits(List<PixabayHits> hits) {
        this.hits = hits;
    }
}

