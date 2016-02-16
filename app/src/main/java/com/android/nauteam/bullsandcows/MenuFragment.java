package com.android.nauteam.bullsandcows;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.view.View.OnClickListener;


public class MenuFragment extends Fragment {

    private Button mresume_button;
    private Button mnew_game_button;
    private Button mscores_button;
    private Button mexit_button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

      /*  mresume_button = (Button) findViewById(R.id.resume_button);
        mnew_game_button = (Button) findViewById(R.id.new_game_button);
        mscores_button = (Button) findViewById(R.id.scores_button);
        mexit_button = (Button) findViewById(R.id.exit_button);
        */
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_menu, parent, false);
        return v;

    }
}


