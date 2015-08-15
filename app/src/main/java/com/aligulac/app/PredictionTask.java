package com.aligulac.app;

import android.os.AsyncTask;

import com.aligulac.app.api.BoNPrediction;
import com.aligulac.app.data.PredictMatch;

import retrofit.RestAdapter;

public class PredictionTask extends AsyncTask<Integer, Void, PredictMatch> {

    private ResultHandler mHandler;

    public PredictionTask(ResultHandler handler) {
        this.mHandler = handler;
    }

    /**
     * Provide playerId1, playerId2, length of Bo
     * so we have 3 elements in total
     *
     * @param params
     * @return Match prediction or null if something went wrong
     */
    @Override
    protected PredictMatch doInBackground(Integer... params) {
        if (params.length == 3) {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(AligulacConstants.BASE_URL)
              .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setRequestInterceptor(new AligulacRequestInterceptor())
                    .build();

            BoNPrediction prediction = restAdapter.create(BoNPrediction.class);
            PredictMatch match = prediction.predictBoNMatch(params[0], params[1], params[2]);

            return match;
        } else
            return null;
    }

    @Override
    protected void onPostExecute(PredictMatch prediction) {
        if (mHandler != null)
            mHandler.onResultReceived(prediction);
    }

}
