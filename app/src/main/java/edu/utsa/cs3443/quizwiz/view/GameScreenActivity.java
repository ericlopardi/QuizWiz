/**
 * @author - Josh Shelley (mzk160), Ria James (xuv730), Eric Lopardi (eif833), Zachary Sierra (tnb644)
 *
 * this class represents the Activity screen for the game, this class also implements the controllers using anonymous classes.
 */

package edu.utsa.cs3443.quizwiz.view;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;
import edu.utsa.cs3443.quizwiz.R;
import edu.utsa.cs3443.quizwiz.model.Inquiry;

public class GameScreenActivity extends AppCompatActivity {

    ImageView ivInquiry;
    TextView tvInquiry, tvInquiriesLeft;
    Button btnAnswer0, btnAnswer1, btnAnswer2, btnAnswer3, btnSubmit;
    int curInquiry, curInquiryIdx;
    static int totalCorrect, totalInquiries;
    final int maxInquiriesPerRound = 5;
    ArrayList<Inquiry> bank;

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
        setContentView(R.layout.activity_game_screen);

        ivInquiry = findViewById(R.id.inquiryImageView);
        tvInquiry = findViewById(R.id.inquiryTextView);
        tvInquiriesLeft = findViewById(R.id.inquiriesRemNumTextView);
        btnAnswer0 = findViewById(R.id.answer0Btn);
        btnAnswer1 = findViewById(R.id.answer1Btn);
        btnAnswer2 = findViewById(R.id.answer2Btn);
        btnAnswer3 = findViewById(R.id.answer3Btn);
        btnSubmit = findViewById(R.id.submitBtn);

        /**
         * Controller implementations for GameScreenActivity
         */
        btnAnswer0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerSelected(0);
            }
        });
        btnAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerSelected(1);
            }
        });
        btnAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerSelected(2);
            }
        });
        btnAnswer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerSelected(3);
            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "NULL";
                Intent intent = getIntent();
                System.out.println(intent.getStringExtra("Entertainment"));
                System.out.println(intent.getStringExtra("Science"));
                System.out.println(intent.getStringExtra("History"));
                System.out.println(intent.getStringExtra("Sports"));
                if(Objects.equals(intent.getStringExtra("Entertainment"), "entertainment")) {
                    message = "entertainment";
                } else if(Objects.equals(intent.getStringExtra("Science"), "science")) {
                    message = "science";
                } else if(Objects.equals(intent.getStringExtra("History"), "history")) {
                    message = "history";
                } else if(Objects.equals(intent.getStringExtra("Sports"), "sports")) {
                    message = "sports";
                } else {
                    System.out.println("ERROR: Could not load any games, possible error with retrieving intents or comparing intent strings");
                }
                answerSubmission(message);
            }
        });
        try {
            launchQuiz();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param insertInquiry - Inquiry object to be inserted into function to generate/show the current inquiry
     */
    public void showInquiry(Inquiry insertInquiry) {
        ivInquiry.setImageResource(getCurInquiry().getPicResID());
        tvInquiry.setText(getCurInquiry().getInquiryString());
        btnAnswer0.setText(getCurInquiry().getFirstAnsChoice());
        btnAnswer1.setText(getCurInquiry().getSecondAnsChoice());
        btnAnswer2.setText(getCurInquiry().getThirdAnsChoice());
        btnAnswer3.setText(getCurInquiry().getFourthAnsChoice());
    }

    /**
     * @param insertInquiriesRemaining - Integer representing the amount of inquiries left in the quiz
     */
    public void showInquiriesRemaining(int insertInquiriesRemaining) {
        tvInquiriesLeft.setText(String.valueOf(insertInquiriesRemaining));
    }

    /**
     * load function for Entertainment quiz
     * @throws IOException
     */
    public void loadEntertainment() throws IOException {
        AssetManager am = getAssets();
        InputStream is = am.open("entertainment.csv");
        bank = new ArrayList<>();
        ArrayList<Integer> resIDs = new ArrayList<>();
        resIDs.add(R.drawable.grinch);
        resIDs.add(R.drawable.matrix);
        resIDs.add(R.drawable.buzz);
        resIDs.add(R.drawable.pokemon);
        resIDs.add(R.drawable.tootsiepop);
        resIDs.add(R.drawable.avengers);
        resIDs.add(R.drawable.cocacola);
        resIDs.add(R.drawable.dog);
        resIDs.add(R.drawable.applelogo);
        resIDs.add(R.drawable.firstcolormovie);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String curLine;
        int idx = 0;
        while((curLine = br.readLine()) != null) {
            String[] questionInfo = curLine.split(",");
            Inquiry newInquiry = new Inquiry(questionInfo[0], questionInfo[1], questionInfo[2], questionInfo[3], questionInfo[4], Integer.parseInt(questionInfo[5]));
            newInquiry.setPicResID(resIDs.get(idx));
            idx++;
            bank.add(newInquiry);
        }
        br.close();
    }

    /**
     * load function for History quiz
     * @throws IOException
     */
    public void loadHistory() throws IOException {
        AssetManager am = getAssets();
        InputStream is = am.open("history.csv");
        bank = new ArrayList<>();
        ArrayList<Integer> resIDs = new ArrayList<>();
        resIDs.add(R.drawable.columbus);
        resIDs.add(R.drawable.president);
        resIDs.add(R.drawable.wwone);
        resIDs.add(R.drawable.pharaoh);
        resIDs.add(R.drawable.romeojuliet);
        resIDs.add(R.drawable.sistinechapel);
        resIDs.add(R.drawable.telephone);
        resIDs.add(R.drawable.civilwar);
        resIDs.add(R.drawable.magellan);
        resIDs.add(R.drawable.wwtwo);
        resIDs.add(R.drawable.primeminister);
        resIDs.add(R.drawable.president);
        resIDs.add(R.drawable.sovietunion);
        resIDs.add(R.drawable.renaissance);
        resIDs.add(R.drawable.rome);
        resIDs.add(R.drawable.monalisa);
        resIDs.add(R.drawable.president);
        resIDs.add(R.drawable.charlesdarwin);
        resIDs.add(R.drawable.famousnovel);
        resIDs.add(R.drawable.appianway);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String curLine;
        int idx = 0;
        while((curLine = br.readLine()) != null) {
            String[] questionInfo = curLine.split(",");
            Inquiry newInquiry = new Inquiry(questionInfo[0], questionInfo[1], questionInfo[2], questionInfo[3], questionInfo[4], Integer.parseInt(questionInfo[5]));
            newInquiry.setPicResID(resIDs.get(idx));
            idx++;
            bank.add(newInquiry);
        }
        br.close();
    }

    /**
     * load function for Science quiz
     * @throws IOException
     */
    public void loadScience() throws IOException {
        AssetManager am = getAssets();
        InputStream is = am.open("science.csv");
        bank = new ArrayList<>();
        ArrayList<Integer> resIDs = new ArrayList<>();
        resIDs.add(R.drawable.oop);
        resIDs.add(R.drawable.rainbow);
        resIDs.add(R.drawable.solarsystem);
        resIDs.add(R.drawable.fossils);
        resIDs.add(R.drawable.mammal);
        resIDs.add(R.drawable.iron);
        resIDs.add(R.drawable.plants);
        resIDs.add(R.drawable.virus);
        resIDs.add(R.drawable.water);
        resIDs.add(R.drawable.atom);
        resIDs.add(R.drawable.cells);
        resIDs.add(R.drawable.brain);
        resIDs.add(R.drawable.infrared);
        resIDs.add(R.drawable.organs);
        resIDs.add(R.drawable.webpages);
        resIDs.add(R.drawable.sublimation);
        resIDs.add(R.drawable.energy);
        resIDs.add(R.drawable.calorie);
        resIDs.add(R.drawable.devices);
        resIDs.add(R.drawable.os);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String curLine;
        int idx = 0;
        while((curLine = br.readLine()) != null) {
            String[] questionInfo = curLine.split(",");
            Inquiry newInquiry = new Inquiry(questionInfo[0], questionInfo[1], questionInfo[2], questionInfo[3], questionInfo[4], Integer.parseInt(questionInfo[5]));
            newInquiry.setPicResID(resIDs.get(idx));
            idx++;
            bank.add(newInquiry);
        }
        br.close();
    }

    /**
     * laod function for Sports quiz
     * @throws IOException
     */
    public void loadSports() throws IOException {
        AssetManager am = getAssets();
        InputStream is = am.open("sports.csv");
        bank = new ArrayList<>();
        ArrayList<Integer> resIDs = new ArrayList<>();
        resIDs.add(R.drawable.marathon);
        resIDs.add(R.drawable.nbalogo);
        resIDs.add(R.drawable.buffalobills);
        resIDs.add(R.drawable.homerun);
        resIDs.add(R.drawable.stanleycup);
        resIDs.add(R.drawable.timduncan);
        resIDs.add(R.drawable.golfholes);
        resIDs.add(R.drawable.football);
        resIDs.add(R.drawable.tennisball);
        resIDs.add(R.drawable.usainbolt);
        resIDs.add(R.drawable.tombrady);
        resIDs.add(R.drawable.jockey);
        resIDs.add(R.drawable.strike);
        resIDs.add(R.drawable.lebronjames);
        resIDs.add(R.drawable.soccergoal);
        resIDs.add(R.drawable.noball);
        resIDs.add(R.drawable.boxing);
        resIDs.add(R.drawable.medals);
        resIDs.add(R.drawable.touchdown);
        resIDs.add(R.drawable.baseballbases);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String curLine;
        int idx = 0;
        while((curLine = br.readLine()) != null) {
            String[] questionInfo = curLine.split(",");
            Inquiry newInquiry = new Inquiry(questionInfo[0], questionInfo[1], questionInfo[2], questionInfo[3], questionInfo[4], Integer.parseInt(questionInfo[5]));
            newInquiry.setPicResID(resIDs.get(idx));
            idx++;
            bank.add(newInquiry);
        }
        br.close();
    }

    /**
     * functionality for starting a new quiz
     * @throws IOException
     */
    public void launchQuiz() throws IOException {
        Intent intent = getIntent();

        if(Objects.equals(intent.getStringExtra("Entertainment"), "entertainment")) {
            loadEntertainment();
        } else if(Objects.equals(intent.getStringExtra("Science"), "science")) {
            loadScience();
        } else if(Objects.equals(intent.getStringExtra("History"), "history")) {
            loadHistory();
        } else if(Objects.equals(intent.getStringExtra("Sports"), "sports")) {
            loadSports();
        } else {
            System.out.println("ERROR: Could not load any games, possible error with retrieving intents or comparing intent strings");

        }

        while(bank.size() > maxInquiriesPerRound) {
            int removeInquiry = createRandNum(bank.size());
            bank.remove(removeInquiry);
        }
        totalCorrect = 0;
        totalInquiries = bank.size();
        Inquiry leadInquiry = newInquiry();
        showInquiriesRemaining(bank.size());
        showInquiry(leadInquiry);
    }

    /**
     * functionality for generating a new Inquiry
     * @return - Inquiry object
     */
    public Inquiry newInquiry() {
        int newInquiryIdx = createRandNum(bank.size());
        curInquiry = newInquiryIdx;
        return bank.get(curInquiry);
    }

    /**
     * functionality for getting the current Inquiry
     * @return - Inquiry object
     */
    public Inquiry getCurInquiry() {
        return bank.get(curInquiryIdx);
    }

    /**
     * functionality for generating a random number, helper method for other methods in the app
     * @param insertMax - max possible number to generate between 0 - insertMax
     * @return - int representing the random number generated
     */
    public int createRandNum(int insertMax) {
        double randNum = Math.random();
        double retVal = randNum * insertMax;
        return (int) retVal;
    }

    /**
     * functionality for button presses
     * @param insertAnswerSelected - int representing the answer choice selected
     */
    public void answerSelected(int insertAnswerSelected) {
        Inquiry curInquiry = getCurInquiry();
        curInquiry.setUserAnsChoice(insertAnswerSelected);
        btnAnswer0.setText(curInquiry.getFirstAnsChoice());
        btnAnswer1.setText(curInquiry.getSecondAnsChoice());
        btnAnswer2.setText(curInquiry.getThirdAnsChoice());
        btnAnswer3.setText(curInquiry.getFourthAnsChoice());
        switch (insertAnswerSelected) {
            case 0:
                btnAnswer0.setText("✔ " + curInquiry.getFirstAnsChoice());
                break;
            case 1:
                btnAnswer1.setText("✔ " + curInquiry.getSecondAnsChoice());
                break;
            case 2:
                btnAnswer2.setText("✔ " + curInquiry.getThirdAnsChoice());
                break;
            case 3:
                btnAnswer3.setText("✔ " + curInquiry.getFourthAnsChoice());
                break;
            case -1:
                return;
        }
    }

    /**
     * functionality for user answer submissions
     */
    public void answerSubmission(String genre) {
        System.out.println(genre);
        Inquiry curInquiry = getCurInquiry();
        if(curInquiry.isCorrect()) {
            totalCorrect++;
        }
        bank.remove(curInquiry);
        showInquiriesRemaining(bank.size());
        if(bank.size() == 0) {
            //showGameResultDialog();
            Intent intent = new Intent(GameScreenActivity.this, EndGameActivity.class);
            switch(genre){
                case "entertainment":
                    intent.putExtra("Entertainment", "entertainment");
                    break;
                case "sports":
                    intent.putExtra("Sports", "sports");
                    System.out.println("Sports is wok=rkinh");
                    break;
                case "history":
                    intent.putExtra("History", "history");
                    break;
                case "science":
                    intent.putExtra("Science", "science");
                    break;
            }
            startActivity(intent);
        } else {
            newInquiry();
            showInquiry(getCurInquiry());
        }
    }

    /**
     * functionality for presenting end game results
     * @param insertTotalCorrect - total inquiries correct by user
     * @param insertTotalInquiries - total inquiries presented in concluding round
     * @return - String representing the end game results
     */
    public static String gameResults(int insertTotalCorrect, int insertTotalInquiries) {
        return "You answered " + insertTotalCorrect + " out of " + insertTotalInquiries + " correct!";
    }
}