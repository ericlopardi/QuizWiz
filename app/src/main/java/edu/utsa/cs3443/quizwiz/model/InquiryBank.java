/**
 * @author - Josh Shelley (mzk160)
 *
 * This class represents an InquiryBank object in the QuizWiz trivia game
 */

package edu.utsa.cs3443.quizwiz.model;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import edu.utsa.cs3443.quizwiz.R;

public class InquiryBank {
    ArrayList<Inquiry> inquiries;
    Context context;

    public InquiryBank(Context insertContext) {
        inquiries = new ArrayList<>();
        this.context = insertContext;
    }


    public void loadEntertainment() throws IOException {
        InputStream is = context.getAssets().open("entertainment.csv");
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
            inquiries.add(newInquiry);
        }
        br.close();
    }
}
