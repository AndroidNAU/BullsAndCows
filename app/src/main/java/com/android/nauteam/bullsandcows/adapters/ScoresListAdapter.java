package com.android.nauteam.bullsandcows.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.nauteam.bullsandcows.R;
import com.android.nauteam.bullsandcows.Turn;

import java.util.ArrayList;

/**
 * Created by Intelcom on 19.02.2016.
 */
public class ScoresListAdapter  extends ArrayAdapter<Turn> {
    private Context mContext;
    private ArrayList<Turn> mTurnsList;

    public ScoresListAdapter(Context context, ArrayList<Turn> arrayList) {
        super(context, R.layout.item_scores_list);
        mContext =context;
        mTurnsList = arrayList;
    }
    @Override
    public int getCount() {
        return mTurnsList.size();
    }

    @Override
    public Turn getItem(int position) {
        return mTurnsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.item_scores_list, parent, false);

        TextView turnsNumber_textView= (TextView) rowView.findViewById(R.id.turnsNumber_textView);
        TextView finalNumber_textView = (TextView)rowView.findViewById(R.id.finalNumber_textView);


       turnsNumber_textView.setText(""+position);

        return rowView;
    }
}
