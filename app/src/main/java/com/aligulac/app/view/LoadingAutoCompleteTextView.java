package com.aligulac.app.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AutoCompleteTextView;

public class LoadingAutoCompleteTextView extends AutoCompleteTextView {

  private View mLoadingIndicator;

  public LoadingAutoCompleteTextView(Context context) {
    super(context);
  }

  public LoadingAutoCompleteTextView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public LoadingAutoCompleteTextView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  public LoadingAutoCompleteTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
  }

  public void setLoadingIndicator(View view) {
    mLoadingIndicator = view;
  }

  @Override
  protected void performFiltering(CharSequence text, int keyCode) {
    // the AutoCompleteTextView is about to start the filtering so show
    // the ProgressPager
    mLoadingIndicator.setVisibility(View.VISIBLE);
    super.performFiltering(text, keyCode);
  }

  @Override
  public void onFilterComplete(int count) {
    // the AutoCompleteTextView has done its job and it's about to show
    // the drop down so close/hide the ProgressBar
    mLoadingIndicator.setVisibility(View.INVISIBLE);
    super.onFilterComplete(count);
  }


}
