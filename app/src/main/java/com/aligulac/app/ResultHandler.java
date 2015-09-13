package com.aligulac.app;

import retrofit.RetrofitError;

public interface ResultHandler {

  void onResultReceived(Object result);

  void onRequestFailed(RetrofitError cause);
}
