package org.example;

import java.util.regex.Pattern;

public class Game {
    private static final int LENGTH = 3;
    private static final String regex = "\\d{3}";
    private static final Pattern pattern = Pattern.compile(regex);
    private String answer;

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public GameResult guess(String input) throws IllegalArgumentException {
        validateInput(input);

        if (answer.equals(input)) {
            return new GameResult(true, LENGTH, 0);
        }
        int strike = 0;
        int balls = 0;
        for (int i = 0; i < LENGTH; i++) {
            char ci = input.charAt(i);
            for (int j = 0; j < LENGTH; j++) {
                char ansj = this.answer.charAt(j);
                if (ci == ansj) {
                    if (i == j) strike++;
                    else balls++;
                }
            }
        }
        return new GameResult(false, strike, balls);
    }

    private void validateInput(String input) throws IllegalArgumentException {
        if (input == null || !pattern.matcher(input).matches()) {
            throw new IllegalArgumentException("input should be 3-digit string");
        }
        if (hasDuplicatedNumber(input)) {
            throw new IllegalArgumentException("input should contains different characters");
        }
    }

    private static boolean hasDuplicatedNumber(String input) {
        for (int i = 0; i < LENGTH; i++) {
            for (int j = i + 1; j < LENGTH; j++) {
                if (i != j && input.charAt(i) == input.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }
}
