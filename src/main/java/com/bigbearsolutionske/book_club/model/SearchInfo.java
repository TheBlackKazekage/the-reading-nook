package com.bigbearsolutionske.book_club.model;

public class SearchInfo {
    private String textSnipper;

    public SearchInfo(String textSnipper) {
        this.textSnipper = textSnipper;
    }

    public SearchInfo() {
    }

    public String getTextSnipper() {
        return textSnipper;
    }

    public void setTextSnipper(String textSnipper) {
        this.textSnipper = textSnipper;
    }
}
