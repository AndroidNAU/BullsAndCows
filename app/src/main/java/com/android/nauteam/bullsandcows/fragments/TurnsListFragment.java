package com.android.nauteam.bullsandcows.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;

import com.android.nauteam.bullsandcows.R;
import com.android.nauteam.bullsandcows.adapters.TurnsListAdapter;
import com.android.nauteam.bullsandcows.model.NewGame;
import com.android.nauteam.bullsandcows.model.Player;
import com.android.nauteam.bullsandcows.model.Turn;


public class TurnsListFragment extends Fragment {

    private ListView mListView;
    TurnsListAdapter mTurnsListAdapter;
    private ArrayList<Turn> mTurnsList;

    private NewGame mCurrentGame;

    public static TurnsListFragment newInstance() {
      return new TurnsListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCurrentGame = Player.getInstance().getCurrentGame();
        mTurnsList = mCurrentGame.getTurns();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_turns_list, container, false);
        mListView = (ListView) view.findViewById(R.id.listView_turnsList);

        mTurnsListAdapter = new TurnsListAdapter(this.getActivity(), mTurnsList);

        mListView.setAdapter(mTurnsListAdapter);

//        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//        });

        return view;
    }

    public void addTurn(Turn turn) {
        mTurnsList.add(turn);

        mTurnsListAdapter.notifyDataSetChanged();
    }
}
