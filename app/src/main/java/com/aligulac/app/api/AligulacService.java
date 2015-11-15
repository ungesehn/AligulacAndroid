package com.aligulac.app.api;

import com.aligulac.app.BuildConfig;
import retrofit.RestAdapter;

public class AligulacService {

  private static AligulacAPI mInstance;

  private static void createInstance() {
    RestAdapter adapterInstance = new RestAdapter.Builder()
      .setEndpoint(AligulacConstants.BASE_URL)
      .setRequestInterceptor(new AligulacRequestInterceptor())
      .setLogLevel(BuildConfig.DEBUG ? RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.NONE)
      .build();

    mInstance = adapterInstance.create(AligulacAPI.class);
  }

  public static AligulacAPI getInstance() {
    if (mInstance == null)
      createInstance();
    return mInstance;
  }

}
