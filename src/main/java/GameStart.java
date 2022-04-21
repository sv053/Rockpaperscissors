import game.Game;
import game.uiphrases.GamePhrases;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class GameStart {

    private static Scanner scanner;
    private static Game game;

    static {
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {

        game = new Game();
        int gameCycles = 10;
        for (int i = 0; i < gameCycles; i++) {
            int gameMode = 0;
            while (!game.checkEquality(gameMode, Set.of(1, 2))) {
                System.out.println(GamePhrases.GAME_MODE.getPhrase());
                try {
                    gameMode = scanner.nextInt();
                } catch (InputMismatchException ex) {
                    System.out.println("Game mode should be 1 or 2");
                    scanner.nextLine();
                }
            }
            int player1Move = 0;
            while (!game.checkEquality(player1Move, Set.of(1, 2, 3))) {
                System.out.println(GamePhrases.INVITATION_TO_PLAY.getPhrase());
                try {
                    player1Move = scanner.nextInt();
                } catch (InputMismatchException ex) {
                    System.out.println("Please, choose 1, 2 or 3");
                    scanner.nextLine();
                }
            }
            game.playGame(gameMode, --player1Move);
        }
        outputResults();
    }

    private static void outputResults() {

        System.out.println(GamePhrases.WHERE_TO_SAVE.getPhrase());
        int outputMode = 0;
        while (0 == outputMode) {
            try {
                outputMode = scanner.nextInt();
                game.outputGameResult(outputMode);
            } catch (InputMismatchException ex) {
                System.out.println("Please, choose 1 or 2");
                scanner.nextLine();
            }
        }
    }
}

