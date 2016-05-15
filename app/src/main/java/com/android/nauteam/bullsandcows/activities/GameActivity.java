package com.android.nauteam.bullsandcows.activities;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.android.nauteam.bullsandcows.R;
import com.android.nauteam.bullsandcows.fragments.ButtonsFragment;
import com.android.nauteam.bullsandcows.fragments.TurnsListFragment;
import com.android.nauteam.bullsandcows.model.Player;
import com.android.nauteam.bullsandcows.model.Turn;
import com.android.nauteam.bullsandcows.model.Number;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileOutputStream;

public class GameActivity extends AppCompatActivity
    implements ButtonsFragment.OnNumberReadyListener {
    final String filename = "saved_game";

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

    @Override
    protected void onResume()
    {
        super.onResume();

    }



    @Override
    protected void onPause()
    {
        super.onPause();

        Player mPlayer = Player.getInstance();

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String mSavedGame = gson.toJson(mPlayer.getCurrentGame());

        //File file = new File(filename);

        FileOutputStream outputStream;
        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(mSavedGame.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
