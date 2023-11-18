package chess.model;

import chess.constants.PieceType;

/**
 * 
 * @created 26/04/2021
 */
public class Queen extends Piece{
    public Queen(PieceType pieceType) {
        super(pieceType);
    }

    @Override
    public boolean canMove(Board board, Box start, Box end) {
        return false;
    }
}
