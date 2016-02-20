package com.android.nauteam.bullsandcows;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.LinearLayout1);

        if (fragment == null) {
            fragment = new MenuFragment();
            fm.beginTransaction()
                    .add(R.id.LinearLayout1, fragment)
                    .commit();

        }

    }
}




