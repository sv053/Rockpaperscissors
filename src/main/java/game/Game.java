package game;

import game.uiphrases.GamePhrases;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

public class Game {

    public static int PLAYER1_SCORE = 0;
    public static int PLAYER2_SCORE = 0;
    public static int TIE = 0;
    private GameRound gameRound;

    public boolean checkEquality(Integer number, Set<Integer> equalNumbers) {
        return equalNumbers.contains(number);
    }

    public void playGame(int gameMode, int player1Move) {
        gameRound = new GameRound();
        int player2Move = gameRound.createPlayer2Move(gameMode);
        int roundResult = gameRound.play(player1Move, player2Move);

        if (roundResult > 0) {
            if (roundResult == 111) {
                TIE++;
            } else if (roundResult == 222) {
                PLAYER2_SCORE++;
            } else if (roundResult == 999) {
                PLAYER1_SCORE++;
            }
            String roundOutput = gameRound.prepareStepMovesString(
                    Move.values()[player1Move].name(),
                    Move.values()[player2Move].name(),
                    MoveComparison.WINNER_IS.get(roundResult));
            String generalGameResult = gameRound.prepareResultString(PLAYER1_SCORE, PLAYER2_SCORE, TIE);
            System.out.println(roundOutput);
            System.out.println(generalGameResult);
        }
    }

    public String prepareGameResultString(int score1, int score2, int tie) {
        String gameResult = (PLAYER1_SCORE > PLAYER2_SCORE) ? "Player wins!" : "Computer wins";
        if (TIE > PLAYER1_SCORE && TIE > PLAYER2_SCORE) gameResult = "There is a tie!";
        if (TIE < PLAYER1_SCORE && PLAYER1_SCORE == PLAYER2_SCORE) gameResult = "There is a tie!";
        return "\n" + GamePhrases.PLAYER_SCORE.getPhrase() + score1
                + "\n" + GamePhrases.PC_SCORE.getPhrase() + score2
                + "\n" + GamePhrases.TIE_SCORE.getPhrase() + tie
                + "\n" + gameResult;
    }

    public void outputGameResult(int outputMode) {
        String result = prepareGameResultString(PLAYER1_SCORE, PLAYER2_SCORE, TIE);
        switch (outputMode) {
            case 1:
                System.out.println(result);
                break;
            case 2:
                try {
                    FileWriter fileWriter = new FileWriter("gameResult.txt");
                    fileWriter.write(result);
                    fileWriter.close();
                    System.out.println("The result was saved in the file gameResult.txt");
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}

