package tictactoe;

public enum State {
    NOT_STARTED("Game is not started"), IN_PROGRESS("Game in progress"), X_WINS("X wins"), O_WINS("O wins"), DRAW("Draw");

    String text;
    State(String text) {
        this.text = text;
    }
}
