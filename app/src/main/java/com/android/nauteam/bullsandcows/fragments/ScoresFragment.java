package com.android.nauteam.bullsandcows.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.android.nauteam.bullsandcows.R;
import com.android.nauteam.bullsandcows.adapters.ScoresListAdapter;

import com.android.nauteam.bullsandcows.model.Player;
import com.android.nauteam.bullsandcows.model.Game;

import java.util.ArrayList;


public class ScoresFragment extends Fragment {
    private ListView mListView;
    private Button mBackButton;
    private ArrayList<Game> mGameHistory;
    private ArrayList<String> mScoresList;
    public static ScoresFragment newInstance() {
        return new ScoresFragment();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGameHistory = Player.getInstance().getAllGames();
        for(Game game : mGameHistory)
        {
            String tmp = game.getLevel();
            mScoresList.add(tmp);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scores_list, container, false);
        mListView = (ListView) view.findViewById(R.id.listView_scoresList);
        mBackButton = (Button) view.findViewById(R.id.button_scoresFragment_back);

        ScoresListAdapter mScoresListAdapter = new ScoresListAdapter(this.getActivity(), mScoresList);

        mListView.setAdapter(mScoresListAdapter);

        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }

}
