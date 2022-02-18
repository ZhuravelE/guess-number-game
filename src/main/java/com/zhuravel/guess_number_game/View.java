package com.zhuravel.guess_number_game;

public class View {
    static final String MESSAGE_INPUT = "Enter a number from 0 to 100:";
    static final String MESSAGE_LESS = " is less. Try more:";
    static final String MESSAGE_MORE = " is more. Try more:";
    static final String MESSAGE_GUESSED = "Guessed!!";
    static final String MESSAGE_SUGGEST_MORE = "Would you like to play more? (y/n)";
    static final String MESSAGE_START = "New game starts!";
    static final String MESSAGE_EXIT = "Press 'exit' if you'd like to exit.";
    static final String MESSAGE_WRONG = "You entered a wrong number or command. \nEnter a number from 0 to 100 or " + MESSAGE_EXIT;
    static final String MESSAGE_WRONG_NUMBER = "You entered a wrong number. \nEnter a number from 0 to 100 or " + MESSAGE_EXIT;
    static final String MESSAGE_ATTEMPTS = "All attempts: ";

    public void showMessage(String message) {
        System.out.println(message);
    }
}
