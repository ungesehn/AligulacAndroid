package com.aligulac.app.api;

import com.aligulac.app.data.PredictMatch;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface BoNPrediction {

    @GET("/api/v1/predictmatch/{player1},{player2}")
    PredictMatch predictBoNMatch(@Path("player1") int player1, @Path("player2") int player2, @Query("bo") int boLength);

}
