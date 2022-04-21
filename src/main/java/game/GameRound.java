package game;

import game.uiphrases.GamePhrases;

import java.util.Random;

public class GameRound {

    public int play(int player1Choice, int player2Choice) {
        return MoveComparison.compareMoves(player1Choice, player2Choice);
    }

    public int createPlayer2Move(int gameMode) {
        int player2Move = 0;
        switch (gameMode) {
            case 1:
                player2Move = new Random().nextInt(3);
                break;
            case 2:
                player2Move = Move.ROCK.getMoveNumber() - 1;
                break;
        }
        return player2Move;
    }

    public String prepareStepMovesString(String move1, String move2, String gameResult) {
        return GamePhrases.PLAYER_MOVE.getPhrase() + move1
                + "\n" + GamePhrases.PC_MOVE.getPhrase() + move2
                + "\n" + gameResult;
    }

    public String prepareResultString(int score1, int score2, int tie) {
        return "\n" + GamePhrases.PLAYER_SCORE.getPhrase() + score1
                + "\n" + GamePhrases.PC_SCORE.getPhrase() + score2
                + "\n" + GamePhrases.TIE_SCORE.getPhrase() + tie;
    }
}

