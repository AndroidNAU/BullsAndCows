package com.android.nauteam.bullsandcows;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MenuFragment extends Fragment {

    private Button mResumeButton;
    private Button mNewGameButton;
    private Button mScoresButton;
    private Button mExitButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_menu, parent, false);

        mResumeButton = (Button) v.findViewById(R.id.resume_button);
        mNewGameButton = (Button) v.findViewById(R.id.new_game_button);

        mNewGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DemoGame.class);//DemoGame временный активити
                startActivity(intent);
            }
        });

        mScoresButton = (Button)v.findViewById(R.id.scores_button);
        mScoresButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DemoScores.class);//DemoScores времеенный активити
                startActivity(intent);
            }
        });

        mExitButton = (Button) v.findViewById(R.id.exit_button);
        mExitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), ExitMenu.class);
                startActivity(intent);
            }
        });

        return v;
    }
}
