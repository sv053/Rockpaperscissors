package game;

public enum Move {

    ROCK(1),
    SCISSORS(2),
    PAPER(3);

    private final int moveNumber;

    Move(int moveNumber) {
        this.moveNumber = moveNumber;
    }

    public int getMoveNumber() {
        return moveNumber;
    }
}

