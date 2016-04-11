package com.android.nauteam.bullsandcows;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.nauteam.bullsandcows.activities.GameActivity;
import com.android.nauteam.bullsandcows.activities.ScoresActivity;
import com.android.nauteam.bullsandcows.model.Player;


public class MenuFragment extends Fragment {

    private Player mPlayer;

    private Button mResumeButton;
    private Button mNewGameButton;
    private Button mScoresButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle b = this.getArguments();
        if (b != null) {
            mPlayer = (Player)b.getSerializable("PLAYER");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_menu, parent, false);

        mResumeButton = (Button) v.findViewById(R.id.resume_button);
        mNewGameButton = (Button) v.findViewById(R.id.new_game_button);

        if (mPlayer != null && mPlayer.isGameStarted()) {
            mResumeButton.setEnabled(false);
        }

        mNewGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mPlayer.startNewGame();

                Intent intent = new Intent(getActivity(), GameActivity.class);
                intent.putExtra("NEW_GAME", mPlayer.getCurrentGame());

                startActivity(intent);
            }
        });

        mScoresButton = (Button)v.findViewById(R.id.scores_button);
        mScoresButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ScoresActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }
}
