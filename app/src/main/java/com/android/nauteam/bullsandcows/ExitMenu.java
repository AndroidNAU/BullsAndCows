package com.android.nauteam.bullsandcows;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ExitMenu extends Activity {

    private Button mYes;
    private Button mNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exit_menu);

        mYes = (Button)findViewById(R.id.yes_button);
        mYes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
                AppExit();
            }
        });
    }
    
    public void AppExit() {

        this.finish();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}

