package com.example.loadimgfromjson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JsonModel {
    @SerializedName("Bronze")
    public List<ServentModel> items;
    public List<ServentModel> getItems(){
        return  items;
    }
}
