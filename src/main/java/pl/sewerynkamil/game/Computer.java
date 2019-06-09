package pl.sewerynkamil.game;

import pl.sewerynkamil.board.Board;
import pl.sewerynkamil.board.Graphics;
import pl.sewerynkamil.pieces.PositionsPieces;

import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Author Kamil Seweryn
 */

public class Computer {

    private Random random = new Random();
    private Board board;
    private Graphics graphics;
    private MouseControl mouseControl;

    public Computer(Board board, Graphics graphics, MouseControl mouseControl) {
        this.board = board;
        this.graphics = graphics;
        this.mouseControl = mouseControl;
    }

    public PositionsPieces selectPosition(Set<PositionsPieces> positions) {
        Object[] object = positions.toArray();
        return (PositionsPieces) object[random.nextInt(object.length)];
    }

    public void normalMove(PositionsPieces computerMove, PositionsPieces pickedPosition) {
        board.getNormalMoves().clear();

        board.getNormalMoves().normalMoveCalculator(computerMove, false);

        computerMove = selectPosition(board.getNormalMoves().getPossibleMoves());

        graphics.movePiece(computerMove, pickedPosition);

        mouseControl.setTurn(true);

        mouseControl.endTurn();
    }

    public void queenMove(PositionsPieces computerMove, PositionsPieces pickedPosition) {
        board.getQueenMoves().normalQueenMoveCalculator(computerMove);

        computerMove = selectPosition(board.getQueenMoves().getPossibleQueenMoves());

        graphics.movePiece(computerMove, pickedPosition);

        mouseControl.setTurn(true);

        mouseControl.endTurn();
    }

    public void normalKick(PositionsPieces pickedPosition) {
        board.getQueenKicks().clear();

        board.getNormalKicks().kickMovesCalculator(pickedPosition);

        if (!board.getNormalKicks().getPossibleKickMoves().isEmpty()) {

            PositionsPieces computerKick = selectPosition(board.getNormalKicks().getPossibleKickMoves());

            graphics.kickPiece(computerKick, pickedPosition);

            if (board.getNormalKicks().getPossibleKickMoves().isEmpty()) {

                mouseControl.endKick();

                mouseControl.setTurn(true);
            }
        }
    }

    public void queenKick(PositionsPieces pickedPosition) {
        board.getNormalKicks().clear();

        board.getQueenKicks().calculateAllPossibleQueenKicks(pickedPosition);

        if (!board.getQueenKicks().getPossibleKickMoves().isEmpty()) {

            PositionsPieces computerKick = selectPosition(board.getQueenKicks().getPossibleKickMoves());

            graphics.kickPiece(computerKick, pickedPosition);

            if (board.getQueenKicks().getPossibleKickMoves().isEmpty()) {

                mouseControl.endKick();

                mouseControl.setTurn(true);
            }
        }
    }

    public boolean checkBlacksEnd() {
        return board.getEndGame().getRestOfBlacks().size() == 0;
    }

}
