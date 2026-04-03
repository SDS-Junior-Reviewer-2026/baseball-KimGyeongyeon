package org.example;

import java.util.regex.Pattern;

public class Game {
    private final int LENGTH = 3;
    private final String regex = "\\d{3}";
    private final Pattern pattern = Pattern.compile(regex);
    public void guess(String input) throws IllegalArgumentException {
        if (input == null || !pattern.matcher(input).matches()) {
            throw new IllegalArgumentException("input should be 3-digit string");
        }
    }
}
