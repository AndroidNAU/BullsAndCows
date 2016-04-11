package com.android.nauteam.bullsandcows.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.android.nauteam.bullsandcows.R;
import com.android.nauteam.bullsandcows.fragments.ButtonsFragment;
import com.android.nauteam.bullsandcows.fragments.TurnsListFragment;
import com.android.nauteam.bullsandcows.model.NewGame;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment turnsListFragment = TurnsListFragment.newInstance();
        fragmentManager.beginTransaction().add(R.id.turnsListFragment_container,turnsListFragment).commit();
        Fragment buttonsFragment = ButtonsFragment.newInstance();
        fragmentManager.beginTransaction().add(R.id.buttonsFragment_container,buttonsFragment).commit();
    }
}
