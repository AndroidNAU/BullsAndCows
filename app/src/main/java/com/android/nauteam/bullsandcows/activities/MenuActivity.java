package com.android.nauteam.bullsandcows.activities;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

import com.android.nauteam.bullsandcows.MenuFragment;
import com.android.nauteam.bullsandcows.R;
import com.android.nauteam.bullsandcows.model.Player;

public class MenuActivity extends Activity {

    private Player mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        String pref = "Yarik/pg/1234/t/0987/0/0";
        mPlayer = new Player(pref);

        FragmentManager fm = getFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.FragmentConteiner);

        if (fragment == null) {
            fragment = new MenuFragment();

            Bundle b = new Bundle();
            b.putSerializable("PLAYER", mPlayer);
            fragment.setArguments(b);

            fm.beginTransaction()
                    .add(R.id.FragmentConteiner, fragment)
                    .commit();

        }
    }
}




