package com.tads.motoshared.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.tads.motoshared.R;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void createMotorcycle(View view)
    {
        Intent intent = new Intent(getApplicationContext(), CreateMotorcycle.class);
        startActivity(intent);
    }
}

