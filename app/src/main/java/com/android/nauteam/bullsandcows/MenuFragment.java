package com.android.nauteam.bullsandcows;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.View.OnClickListener;


public class MenuFragment extends Fragment {

    private Button mresume_button;
    private Button mnew_game_button;
    private Button mscores_button;
    private Button mexit_button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_menu, parent, false);

        mresume_button = (Button) v.findViewById(R.id.resume_button);
        mnew_game_button = (Button) v.findViewById(R.id.new_game_button);

        mnew_game_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DemoGame.class);//DemoGame временный активити
                startActivity(intent);
            }
        });
        mscores_button = (Button)v.findViewById(R.id.scores_button);
        mscores_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DemoScores.class);//DemoScores времеенный активити
                startActivity(intent);
            }
        });
        mexit_button = (Button) v.findViewById(R.id.exit_button);

        return v;

    }

}
