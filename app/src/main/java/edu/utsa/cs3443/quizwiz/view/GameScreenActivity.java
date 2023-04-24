package edu.utsa.cs3443.quizwiz.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import edu.utsa.cs3443.quizwiz.R;
import edu.utsa.cs3443.quizwiz.controller.AnswerButtonController;
import edu.utsa.cs3443.quizwiz.controller.SubmitButtonController;
import edu.utsa.cs3443.quizwiz.model.Inquiry;

public class GameScreenActivity extends AppCompatActivity {

    ImageView ivInquiry;
    TextView tvInquiry, tvInquiriesLeft;
    Button btnAnswer0, btnAnswer1, btnAnswer2, btnAnswer3, btnSubmit;
    int curInquiry, curInquiryIdx, totalCorrect, totalInquiries;
    final int maxInquiriesPerRound = 5;
    ArrayList<Inquiry> bank;
    Context c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.wizardlogo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setElevation(0);

        ivInquiry = findViewById(R.id.iv_main_inquiry_image);
        tvInquiry = findViewById(R.id.tv_main_inquiry_title);
        tvInquiriesLeft = findViewById(R.id.tv_main_inquiries_remaining_count);
        btnAnswer0 = findViewById(R.id.btn_main_answer_0);
        btnAnswer1 = findViewById(R.id.btn_main_answer_1);
        btnAnswer2 = findViewById(R.id.btn_main_answer_2);
        btnAnswer3 = findViewById(R.id.btn_main_answer_3);
        btnSubmit = findViewById(R.id.btn_main_submit_answer);

        btnAnswer0.setOnClickListener(new AnswerButtonController());
        btnAnswer1.setOnClickListener(new AnswerButtonController());
        btnAnswer2.setOnClickListener(new AnswerButtonController());
        btnAnswer3.setOnClickListener(new AnswerButtonController());
        btnSubmit.setOnClickListener(new SubmitButtonController());

        launchQuiz();
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
        InputStream is = c.getAssets().open("entertainment.csv");
        // added the picture IDs in the order that the CSV file will be read/parsed so that the picture IDs would be set for the correct question
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
            // TODO: personal note - line below could potentially cause issues, test thoroughly because "get" function in ArrayList class
            //  is supposed to return an object, and we are passing an object to a function that is supposed to accept an int.
            newInquiry.setPicResID(resIDs.get(idx));
            idx++;
            bank.add(newInquiry);
        }
        br.close();
    }

    public void launchQuiz() {
        // maybe this method accepts a parameter that associates it with a specific subject to play?

        // load<insert subject here>

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
}