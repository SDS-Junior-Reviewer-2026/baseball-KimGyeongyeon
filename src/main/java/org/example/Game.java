package org.example;

public class Game {
    private final int LENGTH = 3;
    public void guess(String input) throws IllegalArgumentException {
        if (input == null || input.length() != LENGTH) {
            throw new IllegalArgumentException("input should be 3-digit string");
        }
    }
}
