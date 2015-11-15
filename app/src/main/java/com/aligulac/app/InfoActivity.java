package com.aligulac.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.aligulac.app.api.AligulacConstants;

public class InfoActivity extends AppCompatActivity {

  @Bind(R.id.app_version)
  TextView mTvAppVersion;

  @Bind(R.id.feedback_type)
  Spinner mSpinnerFeedback;

  @Bind(R.id.feedback)
  EditText mEtFeedback;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_info);

    ButterKnife.bind(this);

    getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

    mTvAppVersion.setText(String.format(getString(R.string.app_version), BuildConfig.VERSION_NAME, BuildConfig.VERSION_CODE));
  }

  @OnClick(R.id.btn_send_feedback)
  @SuppressWarnings("unused")
  public void sendFeedback() {

    String type = mSpinnerFeedback.getSelectedItem().toString();
    String text = mEtFeedback.getText().toString();

    Intent intent = new Intent(Intent.ACTION_SEND);
    intent.setType("text/plain");
    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{AligulacConstants.FEEDBACK_MAIL});
    intent.putExtra(Intent.EXTRA_SUBJECT, "[" + type + "]");
    intent.putExtra(Intent.EXTRA_TEXT, text);

    startActivity(Intent.createChooser(intent, "Send Email"));
  }


}
