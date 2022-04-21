package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MoveComparisonTest {

    @Test
    void compareMoves() {
        int player1 = 0;
        int player2 = 0;
        int result = 111;

        assertEquals(result, MoveComparison.compareMoves(player1, player2));
    }
}

