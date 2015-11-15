package com.aligulac.app.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.LruCache;
import android.widget.TextView;
import com.aligulac.app.R;

public class FontHelper {

  public static LruCache<String, Typeface> cache = new LruCache<>(4);

  public static void setFont(Context context, TextView tv, AttributeSet attrs) {

    // Get our custom attributes
    TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.TypefaceTextView, 0, 0);

    try {
      String typefaceName = a.getString(
        R.styleable.TypefaceTextView_typeface);

      if (!tv.isInEditMode() && !TextUtils.isEmpty(typefaceName)) {
        Typeface typeface = cache.get(typefaceName);

        if (typeface == null) {
          typeface = Typeface.createFromAsset(context.getAssets(), String.format("fonts/%s.ttf", typefaceName));

          // Cache the Typeface object
          cache.put(typefaceName, typeface);
        }
        tv.setTypeface(typeface);

        // Note: This flag is required for proper typeface rendering
        tv.setPaintFlags(tv.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
      }
    } finally {
      a.recycle();
    }

  }

}
