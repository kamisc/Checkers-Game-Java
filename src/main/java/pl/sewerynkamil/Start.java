package pl.sewerynkamil;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import pl.sewerynkamil.board.Board;
import pl.sewerynkamil.board.Graphics;
import pl.sewerynkamil.game.MouseControl;

/**
 * Author Kamil Seweryn
 */

public class Start extends Application {

    private Board board = new Board();
    private Graphics graphics = new Graphics(board);
    private MouseControl mouseControl = new MouseControl(graphics,
            board,
            board.getNormalMoves(),
            board.getQueenMoves(),
            board.getNormalKicks(),
            board.getQueenKicks(),
            board.getEndGame());

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(graphics.getBorderPane(), 585, 612, Color.BLACK);
        scene.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseControl.getMouseClick());

        primaryStage.setTitle("Checkers Game - Kamil Seweryn");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);

        graphics.getMenuDesign().getStartGame().setOnAction(e -> {
            primaryStage.close();
            Platform.runLater(() -> new Start().start(new Stage()));
            board.putAllPieces();

        });
    }

    public void restart() {

    }

    public static void main(String[] args) {
        launch(args);
    }

}
