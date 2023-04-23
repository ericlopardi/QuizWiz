/**
 * @author - Josh Shelley (mzk160)
 *
 * This class represents an Inquiry object in the QuizWiz trivia game
 */

package edu.utsa.cs3443.quizwiz.model;

public class Inquiry {
    String inquiryString, firstAnsChoice, secondAnsChoice, thirdAnsChoice, fourthAnsChoice, rightAnsChoice, userAnsChoice;
    int picResID;

    public Inquiry(String insertInquiryString, String insertFirstAnswerChoice, String insertSecondAnswerChoice, String insertThirdAnswerChoice, String insertFourthAnswerChoice, String insertRightAnsChoice, String insertUserAnsChoice, int insertPicResID) {
        this.inquiryString = insertInquiryString;
        this.firstAnsChoice = insertFirstAnswerChoice;
        this.secondAnsChoice = insertSecondAnswerChoice;
        this.thirdAnsChoice = insertThirdAnswerChoice;
        this.fourthAnsChoice = insertFourthAnswerChoice;
        this.rightAnsChoice = insertRightAnsChoice;
        this.userAnsChoice = insertUserAnsChoice;
        this.picResID = insertPicResID;
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

    public String getRightAnsChoice() {
        return rightAnsChoice;
    }

    public void setRightAnsChoice(String rightAnsChoice) {
        this.rightAnsChoice = rightAnsChoice;
    }

    public String getUserAnsChoice() {
        return userAnsChoice;
    }

    public void setUserAnsChoice(String userAnsChoice) {
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
