package com.aligulac.app.api;

import com.aligulac.data.AligulacQuery;
import com.aligulac.data.Player;
import com.aligulac.data.PredictMatch;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface AligulacAPI {

  @GET("/api/v1/player/{id}")
  Player getPlayer(@Path("id") String playerId);

  @GET("/search/json")
  AligulacQuery query(@Query("q") String query);

  @GET("/api/v1/predictmatch/{player1},{player2}")
  void predictBoNMatch(@Path("player1") int player1, @Path("player2") int player2, @Query("bo") int boLength, Callback<PredictMatch> cb);

}
