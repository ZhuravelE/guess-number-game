package com.zhuravel.guess_number_game;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Controller {

    private static final String CMD_EXIT = "^(n|no|exit)$";
    private static final String CMD_YES = "^(y|yes)$";

    private final Model model;
    private final View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void start() {
        view.showMessage(View.MESSAGE_START);
        model.generateRandomNumber();
        getNewInputNumber();
    }

    private boolean checkNumber(Integer number) {
        if (number < 0 || number > 100) {
            view.showMessage(View.MESSAGE_WRONG_NUMBER);
            return false;
        }

        switch (model.checkNumber(number)) {
            case -1 -> {
                view.showMessage(number + View.MESSAGE_LESS);
                return false;
            }
            case 1 -> {
                view.showMessage(number + View.MESSAGE_MORE);
                return false;
            }
            default -> {
                view.showMessage(View.MESSAGE_GUESSED);
                showStatistics();
                view.showMessage(View.MESSAGE_SUGGEST_MORE);
                return true;
            }
        }
    }

    private void getNewInputNumber() {
        view.showMessage(View.MESSAGE_INPUT);

        Scanner sc = new Scanner(System.in);
        String input;
        while (sc.hasNextLine() && !Pattern.matches(CMD_EXIT, (input = sc.nextLine()))) {
            try {
                if (checkNumber(Integer.valueOf(input))) {
                    suggestPlayMore(sc);
                    break;
                }
            } catch (NumberFormatException e) {
                view.showMessage(View.MESSAGE_WRONG);
            }
        }
        sc.close();
    }

    private void suggestPlayMore(Scanner sc) {
        while (true) {
            String input = sc.nextLine();

            if (Pattern.matches(CMD_YES, input)) {
                start();
                break;
            } else if (Pattern.matches(CMD_EXIT, input)) {
                break;
            } else {
                view.showMessage(View.MESSAGE_WRONG);
            }
        }
    }

    private void showStatistics() {
        view.showMessage(View.MESSAGE_ATTEMPTS + model.getNumberOfAttempts() + "\n" + model.getAttempts());
    }
}
