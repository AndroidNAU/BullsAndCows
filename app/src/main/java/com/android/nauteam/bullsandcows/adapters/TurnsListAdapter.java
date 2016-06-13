package com.android.nauteam.bullsandcows.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.android.nauteam.bullsandcows.R;
import com.android.nauteam.bullsandcows.model.Game;
import com.android.nauteam.bullsandcows.model.Player;
import com.android.nauteam.bullsandcows.model.Turn;
import java.util.ArrayList;

public class TurnsListAdapter extends ArrayAdapter<Turn> {

    private Context mContext;
    private ArrayList<Turn> mTurnsList;

    public TurnsListAdapter(Context context, ArrayList<Turn> arrayList) {
        super(context, R.layout.item_turns_list);
        mContext = context;
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
        View rowView = inflater.inflate(R.layout.item_turns_list, parent, false);

        TextView turnNum_textView = (TextView) rowView.findViewById(R.id.turnNum_textView);
        TextView valueNum_textView = (TextView)rowView.findViewById(R.id.valueNum_textView);
        TextView bullsNum_textView= (TextView) rowView.findViewById(R.id.bullsNum_textView);
        TextView cowsNum_textView = (TextView)rowView.findViewById(R.id.cowsNum_textView);


        Turn mCurrentTurn = mTurnsList.get(position);
        Game mCurrentGame = Player.getInstance().getCurrentGame();


        turnNum_textView.setText(""+position);
        valueNum_textView.setText(mCurrentTurn.getNumber().getDigits());
        bullsNum_textView.setText(""+mCurrentGame.getSecretNum().getBulls(mCurrentTurn.getNumber()));
        cowsNum_textView.setText(""+mCurrentGame.getSecretNum().getCows(mCurrentTurn.getNumber()));

        return rowView;
    }
    /////////////////trt
}
