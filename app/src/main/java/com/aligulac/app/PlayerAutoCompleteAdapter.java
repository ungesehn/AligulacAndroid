package com.aligulac.app;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import butterknife.ButterKnife;
import com.aligulac.app.api.AligulacService;
import com.aligulac.data.AligulacQuery;
import com.aligulac.data.AutocompletePlayer;
import hugo.weaving.DebugLog;
import retrofit.RetrofitError;

import java.util.ArrayList;
import java.util.List;

public class PlayerAutoCompleteAdapter extends BaseAdapter implements Filterable {

  private static final String TAG = "PlayerACAdapter";
  private Context mCtx;
  private List<AutocompletePlayer> mItems;
  private int mPlayer;

  private int mSelectedItem = -1;

  public PlayerAutoCompleteAdapter(Context context, int player) {
    mCtx = context;
    mItems = new ArrayList<>();
    mPlayer = player;
  }

  public static String raceToDrawable(String race) {
    if (TextUtils.isEmpty(race))
      return "";
    else {
      switch (race) {
        case "Z":
          return "ic_zerg";
        case "P":
          return "ic_protoss";
        case "T":
          return "ic_terran";
        default:
          return "";
      }
    }
  }

  @DebugLog
  public static String countryToDrawable(String country) {
    return TextUtils.isEmpty(country) ? "" : country.toLowerCase();
  }

  @Override
  public int getCount() {
    return mItems.size();
  }

  @Override
  public AutocompletePlayer getItem(int position) {
    return mItems.get(position);
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    if (convertView == null)
      convertView = LayoutInflater.from(mCtx).inflate(R.layout.elem_player_dropdown, parent, false);

    AutocompletePlayer player = getItem(position);

    ((TextView) convertView.findViewById(R.id.text1)).setText(player.getTag());

    ImageView iv = ButterKnife.findById(convertView, R.id.player_flag);
    int id = mCtx.getResources().getIdentifier(countryToDrawable(player.getCountry()), "drawable", mCtx.getPackageName());
    if (id != 0)
      iv.setImageResource(id);
    else
      iv.setImageDrawable(null);

    iv = ButterKnife.findById(convertView, R.id.player_race);
    id = mCtx.getResources().getIdentifier(raceToDrawable(player.getRace()), "drawable", mCtx.getPackageName());
    if (id != 0)
      iv.setImageResource(id);
    else
      iv.setImageDrawable(null);

    return convertView;
  }

  @Override
  public Filter getFilter() {
    Filter filter = new Filter() {
      @Override
      protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults filterResults = new FilterResults();
        if (constraint != null && mSelectedItem == -1) {
          List<AutocompletePlayer> players = getPlayers(constraint.toString());
          filterResults.values = players;
          filterResults.count = players.size();
          Log.d(TAG, "received " + filterResults.count + " results");
        }
        return filterResults;
      }

      @Override
      protected void publishResults(CharSequence constraint, FilterResults results) {
        if (results != null && results.count > 0) {
          mItems = (List<AutocompletePlayer>) results.values;
          notifyDataSetChanged();
        } else {
          notifyDataSetInvalidated();
        }
      }
    };
    return filter;
  }

  private List<AutocompletePlayer> getPlayers(String name) {
    Log.d(TAG, "requesting::" + name);

    AligulacQuery q = null;

    try {
      q = AligulacService.getInstance().query(name);
    } catch (RetrofitError e) {
      if (e.getKind().equals(RetrofitError.Kind.NETWORK))
        ((MainActivity) mCtx).showError(mPlayer, e.getMessage());
      Log.e(TAG, e.getMessage());

      //return empty list
      return new ArrayList<AutocompletePlayer>();
    }

    return q.getPlayers();
  }

  public AutocompletePlayer getSelectedItem() {
    if (mSelectedItem >= 0 && mItems != null)
      return getItem(mSelectedItem);
    else
      return null;
  }

  public void setSelectedItem(int pos) {
    mSelectedItem = pos;
  }
}
