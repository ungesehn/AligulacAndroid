package com.aligulac.app;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.aligulac.app.api.AligulacService;
import com.aligulac.app.util.ActivityConstants;
import com.aligulac.app.util.Utils;
import com.aligulac.app.view.LoadingAutoCompleteTextView;
import com.aligulac.data.AutocompletePlayer;
import com.aligulac.data.PredictMatch;
import org.parceler.Parcels;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

  @Bind(R.id.player1)
  LoadingAutoCompleteTextView mPlayer1;
  @Bind(R.id.player2)
  LoadingAutoCompleteTextView mPlayer2;

  @Bind(R.id.player1wrapper)
  TextInputLayout mPlayer1wrapper;
  @Bind(R.id.player2wrapper)
  TextInputLayout mPlayer2wrapper;

  @Bind(R.id.bestOf)
  EditText mBestOf;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    setTitle(R.string.activity_prediction);

    //setup player 1 input
    mPlayer1.setAdapter(new PlayerAutoCompleteAdapter(this, 0));
    mPlayer1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mPlayer1.setText(((PlayerAutoCompleteAdapter) mPlayer1.getAdapter()).getItem(position).getTag());
        ((PlayerAutoCompleteAdapter) mPlayer1.getAdapter()).setSelectedItem(position);
        mPlayer1wrapper.setErrorEnabled(false);
      }
    });
    mPlayer1.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {
      }

      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {
        ((PlayerAutoCompleteAdapter) mPlayer1.getAdapter()).setSelectedItem(-1);
      }

      @Override
      public void afterTextChanged(Editable s) {
      }
    });
    mPlayer1.setLoadingIndicator(ButterKnife.findById(this, R.id.player1_loader));

    //setup player 2 input
    mPlayer2.setAdapter(new PlayerAutoCompleteAdapter(this, 1));
    mPlayer2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mPlayer2.setText(((PlayerAutoCompleteAdapter) mPlayer2.getAdapter()).getItem(position).getTag());
        ((PlayerAutoCompleteAdapter) mPlayer2.getAdapter()).setSelectedItem(position);
        mPlayer2wrapper.setErrorEnabled(false);
      }
    });
    mPlayer2.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {
      }

      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {
        ((PlayerAutoCompleteAdapter) mPlayer2.getAdapter()).setSelectedItem(-1);
      }

      @Override
      public void afterTextChanged(Editable s) {
      }
    });
    mPlayer2.setLoadingIndicator(ButterKnife.findById(this, R.id.player2_loader));
  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == R.id.menu_info) {
      showInfoActivity();
      return true;
    } else {
      return super.onOptionsItemSelected(item);
    }
  }

  private void showInfoActivity() {
    Intent intent = new Intent(this, InfoActivity.class);
    startActivity(intent);
  }

  @Override
  protected void onResume() {
    super.onResume();
  }

  @SuppressWarnings("unchecked, unused")
  @OnClick(R.id.btn)
  void submit() {
    AutocompletePlayer p1 = ((PlayerAutoCompleteAdapter) mPlayer1.getAdapter()).getSelectedItem();
    if (p1 == null)
      mPlayer1wrapper.setError(getString(R.string.hint_select_player));

    AutocompletePlayer p2 = ((PlayerAutoCompleteAdapter) mPlayer2.getAdapter()).getSelectedItem();

    if (p2 == null)
      mPlayer2wrapper.setError(getString(R.string.hint_select_player));

    if (mBestOf.getText().toString().isEmpty())
      mBestOf.setError(getString(R.string.hint_select_length));

    if (p1 == null || p2 == null || mBestOf.getText().toString().isEmpty())
      return;

    //check for network connectivity
    if (Utils.isConnected(this)) {

      //get Bo length
      String boLength = mBestOf.getText().toString();

      executeTask(p1.getId(), p2.getId(), Integer.valueOf(boLength));
    } else {
      //show hint to the user if not connected to the internet
      Snackbar.make(ButterKnife.findById(this, R.id.coordinatorLayout),
        R.string.hint_not_connected, Snackbar.LENGTH_LONG).show();
    }
  }

  private void executeTask(int p1, int p2, int bo) {
    AligulacService.getInstance().predictBoNMatch(p1, p2, bo, new Callback<PredictMatch>() {
      @Override
      public void success(PredictMatch predictMatch, Response response) {
        openResultActivity(predictMatch);
      }

      @Override
      public void failure(RetrofitError error) {
        Snackbar.make(findViewById(R.id.coordinatorLayout), "Error", Snackbar.LENGTH_LONG).show();
      }
    });

  }

  @SuppressWarnings("unchecked")
  private void openResultActivity(PredictMatch prediction) {
    Intent intent = new Intent(this, ResultActivity.class);
    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this,
      new Pair<View, String>(mPlayer1, "player1"),
      new Pair<View, String>(mPlayer2, "player2"));

    Parcelable result = Parcels.wrap(prediction);
    Parcelable p1 = Parcels.wrap(((PlayerAutoCompleteAdapter) mPlayer1.getAdapter()).getSelectedItem());
    Parcelable p2 = Parcels.wrap(((PlayerAutoCompleteAdapter) mPlayer2.getAdapter()).getSelectedItem());

    Bundle bundle = options.toBundle();
    bundle.putParcelable(ActivityConstants.BUNDLE_RESULT, result);
    bundle.putParcelable(ActivityConstants.BUNDLE_RESULT_PLAYER_1, p1);
    bundle.putParcelable(ActivityConstants.BUNDLE_RESULT_PLAYER_2, p2);
    intent.putExtras(bundle);

    startActivity(intent, options.toBundle());
  }

  public void showError(final int playerId, final String error) {
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        switch (playerId) {
          case 0:
            mPlayer1wrapper.setError(error);
            break;
          case 1:
            mPlayer2.setError(error);
          default:
            break;
        }
      }
    });
  }

}
