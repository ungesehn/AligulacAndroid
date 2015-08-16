package com.aligulac.app;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.aligulac.data.AutocompletePlayer;

public class MainActivity extends AppCompatActivity {

  @Bind(R.id.player1)
  AutoCompleteTextView mPlayer1;
  @Bind(R.id.player2)
  AutoCompleteTextView mPlayer2;

  @Bind(R.id.player1wrapper)
  TextInputLayout mPlayer1wrapper;
  @Bind(R.id.player2wrapper)
  TextInputLayout mPlayer2wrapper;

  @Bind(R.id.boSelector)
  Spinner mBoSelector;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    mPlayer1.setAdapter(new PlayerAutoCompleteAdapter(this));
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

    mPlayer2.setAdapter(new PlayerAutoCompleteAdapter(this));
    mPlayer2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mPlayer2.setText(((PlayerAutoCompleteAdapter) mPlayer2.getAdapter()).getItem(position).getTag());
        ((PlayerAutoCompleteAdapter) mPlayer2.getAdapter()).setSelectedItem(position);
        mPlayer2wrapper.setErrorEnabled(false);
      }
    });
    mPlayer1.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        mPlayer1wrapper.setHint("Player 1");
      }

      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {
        ((PlayerAutoCompleteAdapter) mPlayer2.getAdapter()).setSelectedItem(-1);
      }

      @Override
      public void afterTextChanged(Editable s) {

      }
    });
  }

  @OnClick(R.id.btn)
  void submit() {
    AutocompletePlayer p1 = ((PlayerAutoCompleteAdapter) mPlayer1.getAdapter()).getSelectedItem();
    if (p1 == null)
      mPlayer1wrapper.setError("Please select player.");

    AutocompletePlayer p2 = ((PlayerAutoCompleteAdapter) mPlayer2.getAdapter()).getSelectedItem();

    if (p2 == null)
      mPlayer2wrapper.setError("Please select player.");

    if (p1 == null || p2 == null)
      return;

    //get Bo length
    String boLength = mBoSelector.getSelectedItem().toString().substring(2, 3);

    Intent intent = new Intent(this, ResultActivity.class);
    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this,
      new Pair<View, String>(mPlayer1, "player1"),
      new Pair<View, String>(mPlayer2, "player2"));

    // start the new activity
    Bundle bundle = options.toBundle();
    bundle.putInt("player1:id", p1.getId());
    bundle.putInt("player2:id", p2.getId());
    bundle.putString("player1:tag", p1.getTag());
    bundle.putString("player2:tag", p2.getTag());
    bundle.putString("bo", boLength);
    intent.putExtras(bundle);
    startActivity(intent, options.toBundle());
  }

}
