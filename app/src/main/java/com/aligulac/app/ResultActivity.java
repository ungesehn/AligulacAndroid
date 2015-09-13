package com.aligulac.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.aligulac.data.Outcomes;
import com.aligulac.data.PredictMatch;
import org.parceler.Parcels;

import java.text.NumberFormat;

public class ResultActivity extends AppCompatActivity {

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
    setContentView(R.layout.activity_result2);
    ButterKnife.bind(this);

    PredictMatch example = Parcels.unwrap(getIntent().getParcelableExtra("prediction"));

    setPredictionResults(example);
  }

  public void setPredictionResults(PredictMatch prediction) {
    mPlayer1.setText(prediction.getPla().getTag());
    mPlayer2.setText(prediction.getPlb().getTag());

    NumberFormat nf = NumberFormat.getPercentInstance();
    nf.setMaximumFractionDigits(2);
    mProbabilityPlayer1.setText(nf.format(prediction.getProba()));
    mProbabilityPlayer2.setText(nf.format(prediction.getProbb()));

    //add outcomes to table
    View root = findViewById(R.id.outcomes_table);
    int rows = Math.round(prediction.getOutcomes().size() / 2);
    for (int i = 0; i < rows; i++) {
      Outcomes out1 = prediction.getOutcomes().get(i);
      Outcomes out2 = prediction.getOutcomes().get(i + rows);

      View row = LayoutInflater.from(this).inflate(R.layout.elem_outcome, (ViewGroup) root, false);
      TextView tv;
      //set outcomes
      tv = ButterKnife.findById(row, R.id.outcome_p1);
      tv.setText(nf.format(out1.getProb()));
      tv = ButterKnife.findById(row, R.id.outcome_p2);
      tv.setText(nf.format(out2.getProb()));
      //set stats
      tv = ButterKnife.findById(row, R.id.stats_p1);
      tv.setText(out1.getScoreCombined());
      tv = ButterKnife.findById(row, R.id.stats_p2);
      tv.setText(out2.getScoreCombined());
      //add to table
      ((ViewGroup) root).addView(row);

    }
  }
}
