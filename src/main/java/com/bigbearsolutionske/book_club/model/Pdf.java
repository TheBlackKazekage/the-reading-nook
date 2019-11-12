package com.bigbearsolutionske.book_club.model;

public class Pdf {
    private boolean isAvailable;

    public Pdf(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Pdf() {
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
