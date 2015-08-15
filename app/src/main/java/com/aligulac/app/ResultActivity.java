package com.aligulac.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.aligulac.app.data.PredictMatch;

import java.text.NumberFormat;

public class ResultActivity extends AppCompatActivity implements ResultHandler {

  @Bind(R.id.player1)
  TextView mPlayer1;
  @Bind(R.id.player2)
  TextView mPlayer2;

  @Bind(R.id.probPlayer1)
  TextView mProbabilityPlayer1;
  @Bind(R.id.probPlayer2)
  TextView mProbabilityPlayer2;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_result);
    ButterKnife.bind(this);

    Bundle bundle = getIntent().getExtras();

    int p1Id = bundle.getInt("player1:id");
    int p2Id = bundle.getInt("player2:id");

    mPlayer1.setText(bundle.getString("player1:tag"));
    mPlayer2.setText(bundle.getString("player2:tag"));


    int boLength = Integer.parseInt(bundle.getString("bo"));

    new PredictionTask(this).execute(p1Id, p2Id, boLength);
  }

  @Override
  public void onResultReceived(Object result) {
    if (result instanceof PredictMatch) {
      PredictMatch prediction = (PredictMatch) result;
      NumberFormat nf = NumberFormat.getPercentInstance();
      nf.setMaximumFractionDigits(2);
      mProbabilityPlayer1.setText(nf.format(prediction.getProba()));
      mProbabilityPlayer2.setText(nf.format(prediction.getProbb()));
    }
  }
}
