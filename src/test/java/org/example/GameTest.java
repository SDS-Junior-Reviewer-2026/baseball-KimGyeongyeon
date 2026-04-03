package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {
    private Game game;

    private void assertIllegalArgument(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            game.guess(input);
        });
    }

    @BeforeEach
    public void setUp() {
        game = new Game();
    }

    @Test
    void createGame() {
        Assertions.assertDoesNotThrow(()->{
            Game game = new Game();
        });
    }

    @Test
    void doesNotThrowWhenValidInput() {
        Assertions.assertDoesNotThrow(()->{
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
}
