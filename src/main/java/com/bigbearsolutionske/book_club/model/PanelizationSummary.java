package com.bigbearsolutionske.book_club.model;

public class PanelizationSummary {
    private boolean containsEpubBubbles;
    private boolean containsImageBubbles;

    public PanelizationSummary(boolean containsEpubBubbles, boolean containsImageBubbles) {
        this.containsEpubBubbles = containsEpubBubbles;
        this.containsImageBubbles = containsImageBubbles;
    }

    public PanelizationSummary() {
    }

    public boolean isContainsEpubBubbles() {
        return containsEpubBubbles;
    }

    public void setContainsEpubBubbles(boolean containsEpubBubbles) {
        this.containsEpubBubbles = containsEpubBubbles;
    }

    public boolean isContainsImageBubbles() {
        return containsImageBubbles;
    }

    public void setContainsImageBubbles(boolean containsImageBubbles) {
        this.containsImageBubbles = containsImageBubbles;
    }

    @Override
    public String toString() {
        return "PanelizationSummary{" +
                "containsEpubBubbles=" + containsEpubBubbles +
                ", containsImageBubbles=" + containsImageBubbles +
                '}';
    }
}
