package org.example;

import org.junit.jupiter.api.Assertions;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {
    private Game game;
    private final static String ANSWER = "123";

    private void assertIllegalArgument(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            game.guess(input);
        });
    }

    private void assertMatchedGameResult(GameResult actual, GameResult expected) {
        assertThat(actual).isNotNull()
        .isEqualTo(expected);
    }

    private void setAnswer(String answer) {
        game.setAnswer(answer);
    }

    @BeforeEach
    public void setUp() {
        game = new Game();
        game.setAnswer(ANSWER);
    }

    @Test
    void createGame() {
        Assertions.assertDoesNotThrow(() -> {
            Game game = new Game();
        });
    }

    @Test
    void doesNotThrowWhenValidInput() {
        Assertions.assertDoesNotThrow(() -> {
            game.guess("789");
        });
    }

    @Test
    void throwExceptionWhenInputIsNull() {
        assertIllegalArgument(null);
    }

    @Test
    void throwExceptionWhenInputIsShorterThan3Digits() {
        assertIllegalArgument("1");
    }

    @Test
    void throwExceptionWhenInputIsLongerThan3Digits() {
        assertIllegalArgument("123456");
    }

    @Test
    void throwExceptionWhenInputIsNotNumber() {
        assertIllegalArgument("12s");
    }

    @Test
    void throwExceptionWhenInputHasDuplicateNumber() {
        assertIllegalArgument("112");
        assertIllegalArgument("121");
        assertIllegalArgument("111");
    }

    @Test
    void returnSolvedResultIfMatchedNumber() {
        // given
        setAnswer("123");
        // when
        GameResult result = game.guess("123");
        // then
        GameResult expected = new GameResult(true, 3, 0);
        assertMatchedGameResult(expected, result);
    }

    @Test
    void returnFailResultIfAllDifferentNumbers() {
        // given
        setAnswer("123");
        // when
        GameResult result = game.guess("456");
        // then
        GameResult expected = new GameResult(false, 0, 0);
        assertMatchedGameResult(expected, result);
    }
}
