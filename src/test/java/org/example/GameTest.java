package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {
    private Game game;

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
    void throwExceptionWhenInputIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            game.guess(null);
        });
    }

    @Test
    void throwExceptionWhenInputIsShorterThan3Digits() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            game.guess("1");
        });
    }

    @Test
    void throwExceptionWhenInputIsLongerThan3Digits() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            game.guess("123456");
        });
    }
}
