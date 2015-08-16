package com.aligulac.app;


import com.aligulac.data.AligulacQuery;

public interface QueryHandler {

  void onQueryResultReceived(AligulacQuery result);
}
