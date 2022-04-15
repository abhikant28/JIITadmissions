package com.example.jiitadmissions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class SplashScreen extends AppCompatActivity {

    Button b_proceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_welcome);

        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}