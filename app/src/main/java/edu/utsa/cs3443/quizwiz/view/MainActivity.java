package edu.utsa.cs3443.quizwiz.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.utsa.cs3443.quizwiz.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSports = findViewById(R.id.sportsbtn);
        Button btnEntertainment = findViewById(R.id.entertainmentbtn);
        Button btnHistory = findViewById(R.id.historybtn);
        Button btnScience = findViewById(R.id.sciencebtn);

        btnSports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GameScreenActivity.class);
                intent.putExtra("Sports", "sports");
                startActivity(intent);
            }
        });
        btnEntertainment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GameScreenActivity.class);
                intent.putExtra("Entertainment", "entertainment");
                startActivity(intent);
            }
        });
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GameScreenActivity.class);
                intent.putExtra("History", "history");
                startActivity(intent);
            }
        });
        btnScience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GameScreenActivity.class);
                intent.putExtra("Science", "science");
                startActivity(intent);
            }
        });
    }
}