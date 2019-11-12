package com.bigbearsolutionske.book_club.model;

public class ReadingMode {
    private String text;
    private String image;

    public ReadingMode(String text, String image) {
        this.text = text;
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ReadingMode{" +
                "text='" + text + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
