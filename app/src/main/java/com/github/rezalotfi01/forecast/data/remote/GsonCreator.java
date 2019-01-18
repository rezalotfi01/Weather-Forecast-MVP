package com.github.rezalotfi01.forecast.data.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class GsonCreator {

    public static Gson createGson() {

        // register possible type adapters here
        return new GsonBuilder().create();
    }
}
