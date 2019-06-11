package pl.sewerynkamil.menu;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import pl.sewerynkamil.Start;
import pl.sewerynkamil.board.Board;

/**
 * Author Kamil Seweryn
 */

public class LoadGame {

    private Board board;

    public LoadGame(Board board) {
        this.board = board;
    }

    public void load(Stage primaryStage) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Load Game");
        alert.setHeaderText(null);
        alert.setContentText("Game Loaded! If you want to play new game, click New Game button in Game Menu.");

        ButtonType ok = new ButtonType("Ok");
        // ButtonType no = new ButtonType("No");

        alert.getButtonTypes().setAll(ok);

        alert.showAndWait();


            Platform.runLater(() -> new Start().start(new Stage()));
            primaryStage.close();

    }
}
