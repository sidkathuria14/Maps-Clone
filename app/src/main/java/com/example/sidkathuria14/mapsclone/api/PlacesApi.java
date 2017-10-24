package com.example.sidkathuria14.mapsclone.api;

import com.example.sidkathuria14.mapsclone.models.models_places.main_places;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by sidkathuria14 on 22/10/17.
 */

public interface PlacesApi {
    @GET("json")
    Call<main_places> call_places(
            @Query("input") String input,
            @Query("key") String key
            );

}