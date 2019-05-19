package pl.sewerynkamil.moves;

import pl.sewerynkamil.board.Board;
import pl.sewerynkamil.pieces.Piece;
import pl.sewerynkamil.pieces.PositionsPieces;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MovesCalculator {

    private Board board;

    private Set<PositionsPieces> allPossibleBlackKicks = new HashSet<>();
    private Set<PositionsPieces> allPossibleWhiteKicks = new HashSet<>();

    public MovesCalculator(Board board) {
        this.board = board;
    }

    // Calculate all possible black kick moves (position where black pieces have white piece around)
    public Set<PositionsPieces> calculateAllPossibleBlackKicks() {
        allPossibleBlackKicks.clear();

        for (Map.Entry<PositionsPieces, Piece> blackPiece : board.getBlackPieces().getBlackPiecesMap().entrySet()) {
            if (new PositionsPieces(blackPiece.getKey().getCol() - 1, blackPiece.getKey().getRow() + 1).isValidPosition()
                    && board.getWhitePieces().isFieldNotNull(new PositionsPieces(blackPiece.getKey().getCol() - 1, blackPiece.getKey().getRow() + 1))) {

                allPossibleBlackKicks.add(new PositionsPieces(blackPiece.getKey().getCol() - 1, blackPiece.getKey().getRow() + 1));
            }

            if (new PositionsPieces(blackPiece.getKey().getCol() + 1, blackPiece.getKey().getRow() + 1).isValidPosition()
                    && board.getWhitePieces().isFieldNotNull(new PositionsPieces(blackPiece.getKey().getCol() + 1, blackPiece.getKey().getRow() + 1))) {
                allPossibleBlackKicks.add(new PositionsPieces(blackPiece.getKey().getCol() + 1, blackPiece.getKey().getRow() + 1));
            }

            if (new PositionsPieces(blackPiece.getKey().getCol() - 1, blackPiece.getKey().getRow() - 1).isValidPosition()
                    && board.getWhitePieces().isFieldNotNull(new PositionsPieces(blackPiece.getKey().getCol() - 1, blackPiece.getKey().getRow() - 1))) {
                allPossibleBlackKicks.add(new PositionsPieces(blackPiece.getKey().getCol() - 1, blackPiece.getKey().getRow() - 1));
            }

            if (new PositionsPieces(blackPiece.getKey().getCol() + 1, blackPiece.getKey().getRow() - 1).isValidPosition()
                    && board.getWhitePieces().isFieldNotNull(new PositionsPieces(blackPiece.getKey().getCol() + 1, blackPiece.getKey().getRow() - 1))) {
                allPossibleBlackKicks.add(new PositionsPieces(blackPiece.getKey().getCol() + 1, blackPiece.getKey().getRow() - 1));
            }
        }
        allPossibleBlackKicks.removeAll(board.getBlackPieces().getBlackPiecesMap().keySet());

        return allPossibleBlackKicks;
    }

    // Calculate all possible white kick moves (position where white pieces have black piece around)
    public Set<PositionsPieces> calculateAllPossibleWhiteKicks() {
        allPossibleWhiteKicks.clear();

        for (Map.Entry<PositionsPieces, Piece> whitePiece : board.getWhitePieces().getWhitePiecesMap().entrySet()) {
            if (new PositionsPieces(whitePiece.getKey().getCol() - 1, whitePiece.getKey().getRow() - 1).isValidPosition()
                    && board.getBlackPieces().isFieldNotNull(new PositionsPieces(whitePiece.getKey().getCol() - 1, whitePiece.getKey().getRow() - 1))) {

                allPossibleWhiteKicks.add(new PositionsPieces(whitePiece.getKey().getCol() - 1, whitePiece.getKey().getRow() - 1));
            }

            if (new PositionsPieces(whitePiece.getKey().getCol() + 1, whitePiece.getKey().getRow() - 1).isValidPosition()
                    && board.getBlackPieces().isFieldNotNull(new PositionsPieces(whitePiece.getKey().getCol() + 1, whitePiece.getKey().getRow() - 1))) {
                allPossibleWhiteKicks.add(new PositionsPieces(whitePiece.getKey().getCol() + 1, whitePiece.getKey().getRow() - 1));
            }

            if (new PositionsPieces(whitePiece.getKey().getCol() - 1, whitePiece.getKey().getRow() + 1).isValidPosition()
                    && board.getBlackPieces().isFieldNotNull(new PositionsPieces(whitePiece.getKey().getCol() - 1, whitePiece.getKey().getRow() + 1))) {
                allPossibleWhiteKicks.add(new PositionsPieces(whitePiece.getKey().getCol() - 1, whitePiece.getKey().getRow() + 1));
            }

            if (new PositionsPieces(whitePiece.getKey().getCol() + 1, whitePiece.getKey().getRow() + 1).isValidPosition()
                    && board.getBlackPieces().isFieldNotNull(new PositionsPieces(whitePiece.getKey().getCol() + 1, whitePiece.getKey().getRow() + 1))) {
                allPossibleWhiteKicks.add(new PositionsPieces(whitePiece.getKey().getCol() + 1, whitePiece.getKey().getRow() + 1));
            }
        }
        allPossibleWhiteKicks.removeAll(board.getWhitePieces().getWhitePiecesMap().keySet());

        return allPossibleWhiteKicks;
    }
}