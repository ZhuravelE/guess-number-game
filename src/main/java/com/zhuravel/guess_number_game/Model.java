package com.zhuravel.guess_number_game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model {

    private Integer random;
    private final List<Integer> numbers = new ArrayList<>();

    void generateRandomNumber() {
        random = new Random().nextInt(100);
    }

    Integer checkNumber(Integer number) {
        numbers.add(number);
        return number.compareTo(random);
    }

    Integer getNumberOfAttempts() {
        return numbers.size();
    }

    List<Integer> getAttempts() {
        return numbers;
    }
}
