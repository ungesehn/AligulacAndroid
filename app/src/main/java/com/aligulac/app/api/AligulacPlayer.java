package com.aligulac.app.api;


import com.aligulac.data.Player;
import retrofit.http.GET;
import retrofit.http.Path;

public interface AligulacPlayer {

  @GET("/api/v1/player/{id}")
  Player getPlayer(@Path("id") String playerId);
}
