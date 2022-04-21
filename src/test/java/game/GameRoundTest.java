package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class GameRoundTest {

    @Test
    void play_success() {
        GameRound gameRound = new GameRound();
        int player1Move = 1;
        int player2Move = 2;
        int expectedResult = gameRound.play(player1Move, player2Move);

        assertEquals(MoveComparison.compareMoves(player1Move, player2Move), expectedResult);
    }

    @Test
    void play_fail() {
        GameRound gameRound = new GameRound();
        int player1Move = 1;
        int player2Move = 2;
        int expectedResult = gameRound.play(player1Move, player2Move);

        assertNotEquals(MoveComparison.compareMoves(player2Move, player1Move), expectedResult);
    }

    @Test
    void createPlayer2Move_caseUnfair_success() {
        int gameMode = 2;
        GameRound gameRound = new GameRound();
        int createdMove = gameRound.createPlayer2Move(gameMode) + 1;

        assertEquals(Move.ROCK.getMoveNumber(), createdMove);
    }

    @Test
    void createPlayer2Move_caseUnfair_fail() {
        int gameMode = 2;
        GameRound gameRound = new GameRound();
        int createdMove = gameRound.createPlayer2Move(gameMode);

        assertNotEquals(Move.ROCK.getMoveNumber(), createdMove);
    }

    @Test
    void prepareStepMovesString_success() {
        GameRound gameRound = new GameRound();
        String testString1 = "t1";
        String testString2 = "t2";
        String gameResultString = "gameResult";
        String expectedResult = "You play: " + testString1 + "\nComputer plays: " + testString2 + "\n" + gameResultString;

        assertEquals(expectedResult, gameRound.prepareStepMovesString(testString1, testString2, gameResultString));
    }

    @Test
    void prepareStepMovesString_fail() {
        GameRound gameRound = new GameRound();
        String testString1 = "t1";
        String testString2 = "t2";
        String gameResultString = "gameResult";
        String expectedResult = "ERR You play: " + testString1 + "\nComputer plays: " + testString2 + "\n" + gameResultString;

        assertNotEquals(expectedResult, gameRound.prepareStepMovesString(testString1, testString2, gameResultString));
    }

    @Test
    void prepareResultString_success() {
        GameRound gameRound = new GameRound();
        int testResult1 = 1;
        int testResult2 = 2;
        int tie = 3;
        String expectedResult = "\n- Your Score: " + testResult1 + "\n- Computer Score: " + testResult2 + "\n- Tie: " + tie;

        assertEquals(expectedResult, gameRound.prepareResultString(testResult1, testResult2, tie));
    }

    @Test
    void prepareResultString_fail() {
        GameRound gameRound = new GameRound();
        int testResult1 = 1;
        int testResult2 = 2;
        int tie = 3;
        String expectedResult = "\n- Your Score__________: " + testResult1 + "\n- Computer Score: " + testResult2 + "\n- Tie: " + tie;

        assertNotEquals(expectedResult, gameRound.prepareResultString(testResult1, testResult2, tie));
    }
}

