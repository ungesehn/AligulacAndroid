package com.aligulac.app.api;

import com.aligulac.app.BuildConfig;
import retrofit.RequestInterceptor;

public class AligulacRequestInterceptor implements RequestInterceptor {

  private static final String API_KEY = BuildConfig.API_KEY;

  @Override
  public void intercept(RequestFacade request) {
    request.addQueryParam("apikey", API_KEY);
  }
}
