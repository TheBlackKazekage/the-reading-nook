package com.bigbearsolutionske.book_club.model;

public class Epub {
    private boolean isAvailable;

    public Epub(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Epub() {
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
