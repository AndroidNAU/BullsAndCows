package com.android.nauteam.bullsandcows.activities;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

import com.android.nauteam.bullsandcows.fragments.MenuFragment;
import com.android.nauteam.bullsandcows.R;

public class MenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        FragmentManager fm = getFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.FragmentConteiner);

        if (fragment == null) {
            fragment = new MenuFragment();

            fm.beginTransaction()
                    .add(R.id.FragmentConteiner, fragment)
                    .commit();

        }
    }
}




