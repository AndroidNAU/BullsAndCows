package com.android.nauteam.bullsandcows;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getFragmentManager();

        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
        if (fragment == null) {
            fragment = new MenuFragment();
            fm.beginTransaction()
                    .add(R.id.fragmentContainer, fragment)
                    .commit();

        }
    }
}




