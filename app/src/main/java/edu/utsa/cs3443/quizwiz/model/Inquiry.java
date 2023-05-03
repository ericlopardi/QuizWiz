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

    /**
     * @return - String description of inquiry
     */
    public String getInquiryString() {
        return inquiryString;
    }

    /**
     * @param inquiryString - String to change the selected inquiry
     */
    public void setInquiryString(String inquiryString) {
        this.inquiryString = inquiryString;
    }

    /**
     * @return - String description of the first potential answer for the current inquiry
     */
    public String getFirstAnsChoice() {
        return firstAnsChoice;
    }

    /**
     * @param firstAnsChoice - String to change the first answer choice for the current inquiry
     */
    public void setFirstAnsChoice(String firstAnsChoice) {
        this.firstAnsChoice = firstAnsChoice;
    }

    /**
     * @return - String description for the second potential answer choice for the current inquiry
     */
    public String getSecondAnsChoice() {
        return secondAnsChoice;
    }

    /**
     * @param secondAnsChoice - String to change the second answer choice for the current inquiry
     */
    public void setSecondAnsChoice(String secondAnsChoice) {
        this.secondAnsChoice = secondAnsChoice;
    }

    /**
     * @return - String description for the third potential answer choice for the current inquiry
     */
    public String getThirdAnsChoice() {
        return thirdAnsChoice;
    }

    /**
     * @param thirdAnsChoice - String to change the third answer choice for the current inquiry
     */
    public void setThirdAnsChoice(String thirdAnsChoice) {
        this.thirdAnsChoice = thirdAnsChoice;
    }

    /**
     * @return - String description for the fourth potential answer choice for the current inquiry
     */
    public String getFourthAnsChoice() {
        return fourthAnsChoice;
    }

    /**
     * @param fourthAnsChoice - String to change the fourth answer choice for the current inquiry
     */
    public void setFourthAnsChoice(String fourthAnsChoice) {
        this.fourthAnsChoice = fourthAnsChoice;
    }

    /**
     * @return - integer that corresponds to the correct answer choice for the current inquiry
     */
    public int getRightAnsChoice() {
        return rightAnsChoice;
    }

    /**
     * @param rightAnsChoice - integer to change the correct answer choice for the current inquiry
     */
    public void setRightAnsChoice(int rightAnsChoice) {
        this.rightAnsChoice = rightAnsChoice;
    }

    /**
     * @return - integer that corresponds to the user's current answer choice for the current inquiry
     */
    public int getUserAnsChoice() {
        return userAnsChoice;
    }

    /**
     * @param userAnsChoice - integer to change the user's current answer choice for the current inquiry
     */
    public void setUserAnsChoice(int userAnsChoice) {
        this.userAnsChoice = userAnsChoice;
    }

    /**
     * @return - integer that corresponds to the image resource ID for the current inquiry
     */
    public int getPicResID() {
        return picResID;
    }

    /**
     * @param picResID - integer to change the image resource ID for the current inquiry
     */
    public void setPicResID(int picResID) {
        this.picResID = picResID;
    }

    /**
     * @return - boolean value to determine whether the user's answer is correct
     */
    public boolean isCorrect() {
        return userAnsChoice == rightAnsChoice;
    }
}
