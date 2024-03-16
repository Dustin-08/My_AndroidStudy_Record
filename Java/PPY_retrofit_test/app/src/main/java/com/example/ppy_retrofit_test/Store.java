package com.example.ppy_retrofit_test;

import com.google.gson.annotations.SerializedName;

public class Store {
    @SerializedName("store_id")
    private int storeId;

    @SerializedName("name")
    private String name;

    @SerializedName("manager_id")
    private String managerId;

    public int getStoreId() {
        return storeId;
    }

    public String getName() {
        return name;
    }

    public String getManagerId() {
        return managerId;
    }
}
