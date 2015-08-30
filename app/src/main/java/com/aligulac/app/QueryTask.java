package com.aligulac.app;

import android.os.AsyncTask;
import com.aligulac.app.api.AligulacQueryInterface;
import com.aligulac.data.AligulacQuery;
import retrofit.RestAdapter;

public class QueryTask extends AsyncTask<String, Void, AligulacQuery> {

  private QueryHandler mHandler;

  public QueryTask(QueryHandler handler) {
    mHandler = handler;
  }

  @Override
  protected AligulacQuery doInBackground(String... params) {
    RestAdapter restAdapter = new RestAdapter.Builder()
      .setEndpoint(AligulacConstants.BASE_URL)
      .build();

    AligulacQueryInterface service = restAdapter.create(AligulacQueryInterface.class);
    return service.query(params[0]);
  }

  @Override
  protected void onPostExecute(AligulacQuery s) {
    mHandler.onQueryResultReceived(s);
  }
}
