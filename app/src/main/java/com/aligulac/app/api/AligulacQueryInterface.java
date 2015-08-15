package com.aligulac.app.api;

import com.aligulac.app.data.AligulacQuery;

import retrofit.http.GET;
import retrofit.http.Query;

public interface AligulacQueryInterface {

    @GET("/search/json")
    AligulacQuery query(@Query("q") String query);
}
