package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class DashFX {

    @FXML
    private Label cmd1;

    @FXML
    private Label cmd2;

    @FXML
    private Label cmd3;

    @FXML
    private Button exitBtn;

    @FXML
    private Button textBtn;

    @FXML
    private TextField textcommand;

    @FXML
    private Button voicecommand;

    @FXML
    void Exit(ActionEvent event) {
        System.exit(0);
        Platform.exit();
    }

    @FXML
    void getCommand(ActionEvent event) {
        String textCmd = textcommand.getText();
        System.out.println(textCmd);
        textcommand.clear();
    }

    @FXML
    void MouseClicked(MouseEvent event) {
        if (event.getSource() == cmd1) {
            textcommand.setText("open calculator");
        } else if (event.getSource() == cmd2) {
            textcommand.setText("open chrome");
        } else if (event.getSource() == cmd3) {
            textcommand.setText("check weather");
        }
    }

}
