package chess.model;

import chess.constants.PieceType;

/**
 *
 * @created 26/04/2021
 */
public class Player extends Account {
    private boolean whiteSide;

    public Player(String name, String email) {
        super(name, email);
        this.whiteSide = false;
    }

    public boolean isWhiteSide() {
        return whiteSide;
    }

    public void setWhiteSide(boolean whiteSide) {
        this.whiteSide = whiteSide;
    }

    @Override
    public String toString() {
        return "bowling.Player{" +
                "whiteSide=" + whiteSide +
                '}';
    }
}
