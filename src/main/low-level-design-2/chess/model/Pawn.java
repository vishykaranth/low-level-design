package chess.model;

import chess.constants.PieceType;

/**
 *
 * @created 26/04/2021
 */
public class Pawn extends Piece {
    public Pawn(PieceType pieceType) {
        super(pieceType);
    }

    @Override
    public boolean canMove(Board board, Box start, Box end) {
        if (end.getPiece() != null && start.getPiece().isWhitePiece() == end.getPiece().isWhitePiece())
            return false;
        Integer xDiff = Math.abs(start.getX() - end.getX());
        Integer yDiff = Math.abs(start.getY() - end.getY());
        return xDiff == 0 && yDiff == 1;
    }
}
