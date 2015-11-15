package com.aligulac.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.aligulac.app.util.ActivityConstants;
import com.aligulac.data.AutocompletePlayer;
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
    setContentView(R.layout.activity_result);
    ButterKnife.bind(this);

    Intent intent = getIntent();

    PredictMatch prediction = Parcels.unwrap(intent.getParcelableExtra(ActivityConstants.BUNDLE_RESULT));
    AutocompletePlayer player1 = Parcels.unwrap(intent.getParcelableExtra(ActivityConstants.BUNDLE_RESULT_PLAYER_1));
    AutocompletePlayer player2 = Parcels.unwrap(intent.getParcelableExtra(ActivityConstants.BUNDLE_RESULT_PLAYER_2));

    setPlayers(player1, player2);
    setPredictionResults(prediction);
  }

  private void setPlayers(AutocompletePlayer player1, AutocompletePlayer player2) {
    mPlayer1.setText(player1.getTag());
    mPlayer2.setText(player2.getTag());

    ImageView iv = ButterKnife.findById(this, R.id.flagPlayer1);
    int id = getResources().getIdentifier(PlayerAutoCompleteAdapter.countryToDrawable(player1.getCountry()), "drawable", getPackageName());
    if (id != 0)
      iv.setImageResource(id);
    else
      iv.setImageDrawable(null);

    iv = ButterKnife.findById(this, R.id.flagPlayer2);
    id = getResources().getIdentifier(PlayerAutoCompleteAdapter.countryToDrawable(player2.getCountry()), "drawable", getPackageName());
    if (id != 0)
      iv.setImageResource(id);
    else
      iv.setImageDrawable(null);
  }

  public void setPredictionResults(PredictMatch prediction) {
    NumberFormat nf = NumberFormat.getPercentInstance();
    nf.setMaximumFractionDigits(2);
    mProbabilityPlayer1.setText(nf.format(prediction.getProba()));
    mProbabilityPlayer2.setText(nf.format(prediction.getProbb()));

    //add outcomes to table
    LinearLayout root = ButterKnife.findById(this, R.id.outcomes_table);
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
      if (i < rows - 1) {
        LayoutInflater.from(this).inflate(R.layout.divider, (ViewGroup) root, true);
      }
    }
  }
}
