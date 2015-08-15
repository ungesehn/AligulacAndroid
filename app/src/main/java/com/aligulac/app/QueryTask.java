package com.aligulac.app;

import android.os.AsyncTask;

import com.aligulac.app.api.AligulacQueryInterface;
import com.aligulac.app.data.AligulacQuery;

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
        AligulacQuery q = service.query(params[0]);

        return q;
    }

    @Override
    protected void onPostExecute(AligulacQuery s) {
        mHandler.onQueryResultReceived(s);
    }
}
