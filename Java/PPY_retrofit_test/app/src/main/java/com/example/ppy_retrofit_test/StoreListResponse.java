package com.example.ppy_retrofit_test;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class StoreListResponse {
    @SerializedName("list")
    private List<Store> storeList;

    public List<Store> getStoreList() {
        return storeList;
    }
}