package com.android.nauteam.bullsandcows.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.android.nauteam.bullsandcows.R;
import com.android.nauteam.bullsandcows.fragments.ButtonsFragment;
import com.android.nauteam.bullsandcows.fragments.TurnsListFragment;
import com.android.nauteam.bullsandcows.model.Turn;
import com.android.nauteam.bullsandcows.model.Number;

public class GameActivity extends AppCompatActivity
    implements ButtonsFragment.OnNumberReadyListener {


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

    public void onNumberEntered(String number) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        TurnsListFragment turnsListFragment = (TurnsListFragment) fragmentManager.findFragmentById(R.id.turnsListFragment_container);
        if (turnsListFragment != null) {

            turnsListFragment.addTurn(new Turn( new Number(number) ));
        }
    }
}
