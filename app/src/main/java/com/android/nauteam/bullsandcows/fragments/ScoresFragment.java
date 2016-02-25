package com.android.nauteam.bullsandcows.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.android.nauteam.bullsandcows.R;
import com.android.nauteam.bullsandcows.Turn;
import com.android.nauteam.bullsandcows.adapters.ScoresListAdapter;
import com.android.nauteam.bullsandcows.adapters.TurnsListAdapter;

import java.util.ArrayList;

/**
 * Created by Intelcom on 19.02.2016.
 */
public class ScoresFragment extends Fragment {
    private ListView mListView;
    private Button mBackButton;
    private ArrayList<Turn> mScoresList;
    public static ScoresFragment newInstance()
    {
        ScoresFragment scoresfragment = new ScoresFragment();
        return scoresfragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mScoresList = new ArrayList<>();
        for(int i = 0; i<10; i++)
        {
            Turn t = new Turn();
            mScoresList.add(t);
        }
    }

    @Nullable
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
