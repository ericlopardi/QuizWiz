/**
 * @author - Josh Shelley (mzk160), Ria James (xuv730), Eric Lopardi (eif833), Zachary Sierra (tnb644)
 *
 * This class represents an Inquiry object in the QuizWiz trivia game
 */

package edu.utsa.cs3443.quizwiz.model;

public class Inquiry {
    String inquiryString, firstAnsChoice, secondAnsChoice, thirdAnsChoice, fourthAnsChoice;
    int picResID, rightAnsChoice, userAnsChoice;

    public Inquiry(String insertInquiryString, String insertFirstAnswerChoice, String insertSecondAnswerChoice, String insertThirdAnswerChoice, String insertFourthAnswerChoice, int insertRightAnsChoice) {
        this.inquiryString = insertInquiryString;
        this.firstAnsChoice = insertFirstAnswerChoice;
        this.secondAnsChoice = insertSecondAnswerChoice;
        this.thirdAnsChoice = insertThirdAnswerChoice;
        this.fourthAnsChoice = insertFourthAnswerChoice;
        this.rightAnsChoice = insertRightAnsChoice;
        this.picResID = 0;
        this.userAnsChoice = -1;
    }

    public String getInquiryString() {
        return inquiryString;
    }

    public void setInquiryString(String inquiryString) {
        this.inquiryString = inquiryString;
    }

    public String getFirstAnsChoice() {
        return firstAnsChoice;
    }

    public void setFirstAnsChoice(String firstAnsChoice) {
        this.firstAnsChoice = firstAnsChoice;
    }

    public String getSecondAnsChoice() {
        return secondAnsChoice;
    }

    public void setSecondAnsChoice(String secondAnsChoice) {
        this.secondAnsChoice = secondAnsChoice;
    }

    public String getThirdAnsChoice() {
        return thirdAnsChoice;
    }

    public void setThirdAnsChoice(String thirdAnsChoice) {
        this.thirdAnsChoice = thirdAnsChoice;
    }

    public String getFourthAnsChoice() {
        return fourthAnsChoice;
    }

    public void setFourthAnsChoice(String fourthAnsChoice) {
        this.fourthAnsChoice = fourthAnsChoice;
    }

    public int getRightAnsChoice() {
        return rightAnsChoice;
    }

    public void setRightAnsChoice(int rightAnsChoice) {
        this.rightAnsChoice = rightAnsChoice;
    }

    public int getUserAnsChoice() {
        return userAnsChoice;
    }

    public void setUserAnsChoice(int userAnsChoice) {
        this.userAnsChoice = userAnsChoice;
    }

    public int getPicResID() {
        return picResID;
    }

    public void setPicResID(int picResID) {
        this.picResID = picResID;
    }

    public boolean isCorrect() {
        return userAnsChoice == rightAnsChoice;
    }
}
