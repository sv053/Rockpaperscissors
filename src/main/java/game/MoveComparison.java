package game;

import java.util.Map;

public class MoveComparison {

    public final static Map<Integer, String> WINNER_IS;

    private static final int[][] comparingTable = {
            {111, 222, 999},
            {999, 111, 222},
            {222, 999, 111}
    };

    static {
        WINNER_IS = Map.of(
                999, "Player wins!",
                222, "Computer wins!",
                111, "It is a tie");
    }

    public static int compareMoves(int player1Move, int player2Move) {
        return comparingTable[player2Move][player1Move];
    }
}

