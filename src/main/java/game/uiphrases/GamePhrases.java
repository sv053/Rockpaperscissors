package game.uiphrases;

import game.Move;

public enum GamePhrases {

    PLAYER_MOVE("You play: "),
    PC_MOVE("Computer plays: "),
    PLAYER_SCORE("- Your Score: "),
    PC_SCORE("- Computer Score: "),
    TIE_SCORE("- Tie: "),
    GAME_MODE("\nMode Selection:\n" +
            "(1) Fair\n" +
            "(2) Unfair\n"),
    INVITATION_TO_PLAY("Enter the number corresponding to your choice: \n" +
            Move.values()[0].getMoveNumber() + ". " + Move.values()[0] + "\n" +
            Move.values()[1].getMoveNumber() + ". " + Move.values()[1] + "\n" +
            Move.values()[2].getMoveNumber() + ". " + Move.values()[2] + "\n"),
    WHERE_TO_SAVE("\n The game result has to be \n(1) shown in console" +
            "\n(2) saved to file\n");

    public final String phrase;

    GamePhrases(String message) {
        phrase = message;
    }

    public String getPhrase() {
        return phrase;
    }
}

