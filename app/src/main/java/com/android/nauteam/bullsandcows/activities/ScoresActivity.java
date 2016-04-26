package com.android.nauteam.bullsandcows.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.nauteam.bullsandcows.R;
import com.android.nauteam.bullsandcows.fragments.ScoresFragment;

public class ScoresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment scoresListFragment = ScoresFragment.newInstance();
        fragmentManager.beginTransaction().add(R.id.scoresListFragment_container,scoresListFragment).commit();
    }
}
