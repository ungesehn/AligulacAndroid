package com.aligulac.app;

import com.aligulac.app.data.AligulacQuery;

public interface QueryHandler {

    void onQueryResultReceived(AligulacQuery result);
}
