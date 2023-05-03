/**
 * @author - Josh Shelley (mzk160)
 * @author - Eric Lopardi (eif833)
 * @author - Ria James (xuv730)
 * @author - Zachary Sierra (tnb644)
 * this class represents the Menu screen for the game
 */

package edu.utsa.cs3443.quizwiz.view;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import edu.utsa.cs3443.quizwiz.R;

public class MainActivity extends AppCompatActivity {
    /**
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSports = findViewById(R.id.sportsbtn);
        Button btnEntertainment = findViewById(R.id.entertainmentbtn);
        Button btnHistory = findViewById(R.id.historybtn);
        Button btnScience = findViewById(R.id.sciencebtn);
        Button btnTutorial = findViewById(R.id.tutorialbtn);

        /**
         * Control implementations for MainActivity (Anonymous classes)
         */
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
        btnTutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TutorialActivity.class);
                startActivity(intent);
            }
        });
    }
}