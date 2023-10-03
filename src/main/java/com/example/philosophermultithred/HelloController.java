package com.example.philosophermultithred;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Circle ph1;
    @FXML
    private Circle ph2;
    @FXML
    private Circle ph3;
    @FXML
    private Circle ph4;
    @FXML
    private Circle ph5;
    @FXML
    private TextArea log;

    private final Philosopher[] philosophers = new Philosopher[5];
    private final Spoon[] spoons = new Spoon[5];

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UILogger uiLogger = new UILogger(log.textProperty());

        for (int i = 0; i < philosophers.length; i++) {
            spoons[i] = new Spoon();
        }

        philosophers[0] = new Philosopher(
                spoons[0],
                spoons[1],
                ph1,
                uiLogger, 1);

        philosophers[1] = new Philosopher(
                spoons[1],
                spoons[2],
                ph2,
                uiLogger, 2);

        philosophers[2] = new Philosopher(
                spoons[2],
                spoons[3],
                ph3,
                uiLogger, 3);

        philosophers[3] = new Philosopher(
                spoons[3],
                spoons[4],
                ph4,
                uiLogger, 4);

        philosophers[4] = new Philosopher(
                spoons[1],
                spoons[4],
                ph5,
                uiLogger, 5);
    }

    @FXML
    public void run(){
        for (Philosopher philosopher: philosophers) {
            philosopher.start();
        }
    }

    @FXML
    public void reset(){
        System.out.println("trying to interrupt");
        for (Philosopher philosopher: philosophers) {
            philosopher.interrupt();
        }
        System.out.println("interrupted");
        initialize(null, null);
    }
}