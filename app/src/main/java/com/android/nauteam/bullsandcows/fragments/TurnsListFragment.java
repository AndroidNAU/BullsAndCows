package com.android.nauteam.bullsandcows.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.nauteam.bullsandcows.R;
import com.android.nauteam.bullsandcows.Turn;
import com.android.nauteam.bullsandcows.adapters.TurnsListAdapter;

import java.util.ArrayList;

/**
 * Created by Mr Smith on 04.02.2016.
 */
public class TurnsListFragment extends Fragment {

    private ListView mListView;
    private ArrayList<Turn> mTurnsList;

    public static TurnsListFragment newInstance()
    {
      TurnsListFragment turnsListFragment = new TurnsListFragment();
      return turnsListFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTurnsList = new ArrayList<>();
        for(int i = 0; i<10; i++)
        {
            Turn t = new Turn();
            mTurnsList.add(t);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_turns_list, container, false);
        mListView = (ListView) view.findViewById(R.id.listView_turnsList);

        TurnsListAdapter mTurnsListAdapter = new TurnsListAdapter(this.getActivity(), mTurnsList);

        mListView.setAdapter(mTurnsListAdapter);

//        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//        });

        return view;
    }
}
