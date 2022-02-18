package com.zhuravel.guess_number_game;

public class App {

    public static void main(String[] args) {
        Controller controller = new Controller(new Model(), new View());
        controller.start();
    }
}
