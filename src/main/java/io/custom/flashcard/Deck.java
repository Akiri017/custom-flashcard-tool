package io.custom.flashcard;

import java.util.ArrayList;

public class Deck {
    private ArrayList<flashcard> cards;
    private int currentIndex;

    public Deck() {
        cards = new ArrayList<>();
        currentIndex = 0;
    }

    public void addCard(flashcard card) {
        cards.add(card);
    }

    public flashcard getNextCard() {
        if (currentIndex < cards.size()) {
            return cards.get(currentIndex++);
        }
        return null;
    }

    public boolean hasMoreCards() {
        return currentIndex < cards.size();
    }

    public void resetDeck() {
        currentIndex = 0;
    }

    public int getCardCount() {
        return cards.size();
    }

    public flashcard getCardAt(int index) {
        if (index >= 0 && index < cards.size()) {
            return cards.get(index);
        }
        return null;
    }

    public ArrayList<flashcard> getAllCards() {
        return cards;
    }
}
