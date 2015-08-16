package com.aligulac.app;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import com.aligulac.app.api.AligulacQueryInterface;
import com.aligulac.data.AligulacQuery;
import com.aligulac.data.AutocompletePlayer;
import retrofit.RestAdapter;

import java.util.ArrayList;
import java.util.List;

public class PlayerAutoCompleteAdapter extends BaseAdapter implements Filterable {

  private static final String TAG = "PlayerACAdapter";
  private Context mCtx;
  private List<AutocompletePlayer> mItems;

  private int mSelectedItem = -1;

  public PlayerAutoCompleteAdapter(Context context) {
    mCtx = context;
    mItems = new ArrayList<>();
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
      convertView = LayoutInflater.from(mCtx).inflate(android.R.layout.simple_dropdown_item_1line, parent, false);

    ((TextView) convertView.findViewById(android.R.id.text1)).setText(getItem(position).getTag());

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
    Log.d("PlayerAutoCompleteAdapter", "requesting::" + name);

    RestAdapter restAdapter = new RestAdapter.Builder()
      .setEndpoint(AligulacConstants.BASE_URL)
      .setLogLevel(RestAdapter.LogLevel.FULL)
      .build();

    AligulacQueryInterface service = restAdapter.create(AligulacQueryInterface.class);
    AligulacQuery q = service.query(name);

    return q.getPlayers();
  }

  public void setSelectedItem(int pos) {
    mSelectedItem = pos;
  }

  public AutocompletePlayer getSelectedItem() {
    if (mSelectedItem >= 0 && mItems != null)
      return getItem(mSelectedItem);
    else
      return null;
  }
}
