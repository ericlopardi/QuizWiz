/**
 * @author - Josh Shelley (mzk160), Ria James (xuv730), Eric Lopardi (eif833), Zachary Sierra (tnb644)
 *
 * this class represents the Activity screen for the end of the game, this class also implements the controllers using anonymous classes.
 */

package edu.utsa.cs3443.quizwiz.view;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Objects;
import edu.utsa.cs3443.quizwiz.R;

public class EndGameActivity extends AppCompatActivity {

    /**
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        TextView tvResults = findViewById(R.id.results);
        Button btnMainMenu = findViewById(R.id.mainmenubtn);
        Button btnRestart = findViewById(R.id.restartbtn);

        /**
         * Controller implementations for EndGameActivity (anonymous classes)
         */
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
                Intent i = getIntent();
                Intent intent = new Intent(EndGameActivity.this, GameScreenActivity.class);
                String message = "NULL";
                System.out.println(i.getStringExtra("Entertainment"));
                System.out.println(i.getStringExtra("Science"));
                System.out.println(i.getStringExtra("History"));
                System.out.println(i.getStringExtra("Sports"));
                if(Objects.equals(i.getStringExtra("Entertainment"), "entertainment")) {
                    message = "entertainment";
                } else if(Objects.equals(i.getStringExtra("Science"), "science")) {
                    message = "science";
                } else if(Objects.equals(i.getStringExtra("History"), "history")) {
                    message = "history";
                } else if(Objects.equals(i.getStringExtra("Sports"), "sports")) {
                    message = "sports";
                } else {
                    System.out.println("ERROR: Could not load any games, possible error with retrieving intents or comparing intent strings");
                }

                switch(message){
                    case "entertainment":
                        intent.putExtra("Entertainment", "entertainment");
                        break;
                    case "sports":
                        intent.putExtra("Sports", "sports");
                        break;
                    case "history":
                        intent.putExtra("History", "history");
                        break;
                    case "science":
                        intent.putExtra("Science", "science");
                        break;
                }
                System.out.println(message);
                startActivity(intent);
            }
        });

        tvResults.setText(GameScreenActivity.gameResults(GameScreenActivity.totalCorrect, GameScreenActivity.totalInquiries));

    }
}