package com.aligulac.app.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class TypefaceTextView extends TextView {
  public TypefaceTextView(Context context) {
    super(context);
  }

  public TypefaceTextView(Context context, AttributeSet attrs) {
    super(context, attrs);
    setCustomFont(context, attrs);
  }

  public TypefaceTextView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    setCustomFont(context, attrs);
  }

  @TargetApi(21)
  public TypefaceTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
    setCustomFont(context, attrs);
  }

  private void setCustomFont(Context context, AttributeSet attrs) {
    FontHelper.setFont(context, this, attrs);
  }

}
