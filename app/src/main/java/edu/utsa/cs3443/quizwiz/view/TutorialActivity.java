/**
 * @author Ria James (xuv730), Josh Shelley (mzk160), Eric Lopardi (eif833), Zachary Sierra (tnb644)
 *
 * This class controls the tutorial page by handling the onCreate and onClickListener by passing/grabbing intents.
 */

package edu.utsa.cs3443.quizwiz.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.utsa.cs3443.quizwiz.R;

public class TutorialActivity extends AppCompatActivity {

    /**
     * The onCreate method loads tutorial screen by loading xml file and creates
     * the button to go back to the Main menu.
     *
     * @param savedInstanceState : loads bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        Button btnTutoMainMenu = findViewById(R.id.btnTutoMainMenu);

        /**
         * Controller implementation for TutorialActivity (anonymous class).
         */
        btnTutoMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TutorialActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}