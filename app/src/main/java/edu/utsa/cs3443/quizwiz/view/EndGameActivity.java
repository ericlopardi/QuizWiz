package edu.utsa.cs3443.quizwiz.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.utsa.cs3443.quizwiz.R;

public class EndGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        TextView tvResults = findViewById(R.id.results);
        Button btnMainMenu = findViewById(R.id.mainmenubtn);
        Button btnRestart = findViewById(R.id.restartbtn);

        btnMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EndGameActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EndGameActivity.this, GameScreenActivity.class);
                startActivity(intent);
            }
        });

        tvResults.setText(GameScreenActivity.gameResults(GameScreenActivity.totalCorrect, GameScreenActivity.totalInquiries));

    }
}