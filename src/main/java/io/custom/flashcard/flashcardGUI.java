package io.custom.flashcard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class flashcardGUI {
    private JFrame frame;
    private JPanel panel;
    private JLabel questionLabel;
    private JButton showAnswerButton;
    private JButton nextButton;
    private Deck deck;

    public flashcardGUI(Deck deck) {
        this.deck = deck;

        frame = new JFrame("Flashcard App");
        panel = new JPanel(new BorderLayout());

        questionLabel = new JLabel("Welcome to Flashcard App");
        panel.add(questionLabel, BorderLayout.CENTER);

        showAnswerButton = new JButton("Show Answer");
        nextButton = new JButton("Next Card");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(showAnswerButton);
        buttonPanel.add(nextButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        showAnswerButton.addActionListener(e -> showAnswer());
        nextButton.addActionListener(e -> showNextCard());

        showNextCard();
    }

    private void showAnswer() {
        if (deck.hasMoreCards()) {
            flashcard currentCard = deck.getCardAt(deck.getCardCount() - 1);
            questionLabel.setText("Answer: " + currentCard.getAnswer());
        }
    }

    private void showNextCard() {
        if (deck.hasMoreCards()) {
            flashcard nextCard = deck.getNextCard();
            questionLabel.setText("Question: " + nextCard.getQuestion());
        } else {
            questionLabel.setText("No more cards!");
        }
    }
}
