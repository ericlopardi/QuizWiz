package edu.utsa.cs3443.quizwiz.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.wizardlogo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setElevation(0);
        setContentView(R.layout.activity_game_screen);

        ivInquiry = findViewById(R.id.inquiryImageView);
        tvInquiry = findViewById(R.id.inquiryTextView);
        tvInquiriesLeft = findViewById(R.id.inquiriesRemNumTextView);
        btnAnswer0 = findViewById(R.id.answer0Btn);
        btnAnswer1 = findViewById(R.id.answer1Btn);
        btnAnswer2 = findViewById(R.id.answer2Btn);
        btnAnswer3 = findViewById(R.id.answer3Btn);
        btnSubmit = findViewById(R.id.submitBtn);

//        btnAnswer0.setOnClickListener(new AnswerButtonController());
//        btnAnswer1.setOnClickListener(new AnswerButtonController());
//        btnAnswer2.setOnClickListener(new AnswerButtonController());
//        btnAnswer3.setOnClickListener(new AnswerButtonController());
//        btnSubmit.setOnClickListener(new SubmitButtonController());

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
                answerSubmission();
            }
        });
        try {
            launchQuiz();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showInquiry(Inquiry insertInquiry) {
        ivInquiry.setImageResource(getCurInquiry().getPicResID());
        tvInquiry.setText(getCurInquiry().getInquiryString());
        btnAnswer0.setText(getCurInquiry().getFirstAnsChoice());
        btnAnswer1.setText(getCurInquiry().getSecondAnsChoice());
        btnAnswer2.setText(getCurInquiry().getThirdAnsChoice());
        btnAnswer3.setText(getCurInquiry().getFourthAnsChoice());
    }

    public void showInquiriesRemaining(int insertInquiriesRemaining) {
        tvInquiriesLeft.setText(String.valueOf(insertInquiriesRemaining));
    }

    public void loadEntertainment() throws IOException {
        AssetManager am = getAssets();
        InputStream is = am.open("entertainment.csv");
        // added the picture IDs in the order that the CSV file will be read/parsed so that the picture IDs would be set for the correct question
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
            // TODO: personal note - line below could potentially cause issues, test thoroughly because "get" function in ArrayList class
            //  is supposed to return an object, and we are passing an object to a function that is supposed to accept an int.
            newInquiry.setPicResID(resIDs.get(idx));
            idx++;
            bank.add(newInquiry);
        }
        br.close();
    }

    public void loadScience() throws IOException {
        AssetManager am = getAssets();
        InputStream is = am.open("science.csv");
        bank = new ArrayList<>();
        ArrayList<Integer> resIDs = new ArrayList<>();
        // insert resource IDs for all photos associated with questions, make sure your photos are added in the same order
        // that the questions are listed in the CSV file.
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
            // TODO: personal note - line below could potentially cause issues, test thoroughly because "get" function in ArrayList class
            //  is supposed to return an object, and we are passing an object to a function that is supposed to accept an int.
            newInquiry.setPicResID(resIDs.get(idx));
            idx++;
            bank.add(newInquiry);
        }
        br.close();
    }

    public void loadSports() throws IOException {
        AssetManager am = getAssets();
        InputStream is = am.open("sports.csv");
        bank = new ArrayList<>();
        ArrayList<Integer> resIDs = new ArrayList<>();
        // insert resource IDs for all photos associated with questions, make sure your photos are added in the same order
        // that the questions are listed in the CSV file.
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

    public Inquiry newInquiry() {
        int newInquiryIdx = createRandNum(bank.size());
        curInquiry = newInquiryIdx;
        return bank.get(curInquiry);
    }

    public Inquiry getCurInquiry() {
        return bank.get(curInquiryIdx);
    }

    public int createRandNum(int insertMax) {
        double randNum = Math.random();
        double retVal = randNum * insertMax;
        return (int) retVal;
    }

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

    public void answerSubmission() {
        Inquiry curInquiry = getCurInquiry();
        if(curInquiry.isCorrect()) {
            totalCorrect++;
        }
        bank.remove(curInquiry);
        showInquiriesRemaining(bank.size());
        if(bank.size() == 0) {
            //showGameResultDialog();
            Intent intent = new Intent(GameScreenActivity.this, EndGameActivity.class);
            startActivity(intent);
        } else {
            newInquiry();
            showInquiry(getCurInquiry());
        }
    }

//    public void showGameResultDialog() {
//        String result = gameResults(totalCorrect, totalInquiries);
//        AlertDialog.Builder endGameResult = new AlertDialog.Builder(GameScreenActivity.this);
//        endGameResult.setCancelable(false);
//        endGameResult.setTitle("Quiz has concluded!");
//        endGameResult.setMessage(result);
//        endGameResult.setPositiveButton("Start another round", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                launchQuiz();
//            }
//        });
//        endGameResult.setNegativeButton("Return to Main Menu", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Intent intent = new Intent(GameScreenActivity.this, MainActivity.class);
//                startActivity(intent);
//            }
//        });
//        endGameResult.create().show();
//    }

    public static String gameResults(int insertTotalCorrect, int insertTotalInquiries) {
        return "You answered " + insertTotalCorrect + " out of " + insertTotalInquiries + " correct!";
    }
}