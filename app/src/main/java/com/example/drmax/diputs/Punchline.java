package com.example.drmax.diputs;

/**
 * Created by drmax on 9/16/17.
 */

public class Punchline {

    public String question;
    public String punchline;

    public Punchline(String question, String punchline) {
        this.question = question;
        this.punchline = punchline;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getPunchline() {
        return punchline;
    }

    public void setPunchline(String punchline) {
        this.punchline = punchline;
    }
}
