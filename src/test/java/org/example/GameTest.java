package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    void createGame() {
        Assertions.assertDoesNotThrow(()->{
            Game game = new Game();
        });
    }

    @Test
    void throwExceptionWhenInputIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            Game game = new Game();
            game.guess(null);
        });
    }
}
