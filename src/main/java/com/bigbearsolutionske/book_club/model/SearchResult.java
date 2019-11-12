package com.bigbearsolutionske.book_club.model;

import java.util.List;

public class SearchResult {
    private String kind;
    private int totalItems;
    private List<Item> items;

    public SearchResult(String kind, int totalItems, List<Item> items) {
        this.kind = kind;
        this.totalItems = totalItems;
        this.items = items;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
