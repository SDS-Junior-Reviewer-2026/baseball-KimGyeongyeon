package org.example;

public class Game {
    public void guess(String input) throws IllegalArgumentException {
        if (input == null) {
            throw new IllegalArgumentException("input should be not null");
        }
    }
}
