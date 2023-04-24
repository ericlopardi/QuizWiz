package edu.utsa.cs3443.quizwiz.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.utsa.cs3443.quizwiz.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.wizardlogo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setElevation(0);
    }
}