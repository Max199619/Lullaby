package com.example.lullaby;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LullabyController {


    public TextField hours;
    public TextField minutes;
    public TextField seconds;
    public Button sleepButton;
    public Button hibernateButton;
    public Button rebootButton;
    public Button shutdownButton;

    public void GoToSleep(ActionEvent event) {
        switchOffTextfields();
    }

    public void Hibernate(ActionEvent event) {
        switchOffTextfields();
    }

    public void Restart(ActionEvent event) {
        switchOffTextfields();
    }

    public void SwitchOff(ActionEvent event) {
        switchOffTextfields();
    }

    private void switchOffTextfields(){
        hours.setDisable(true);
        minutes.setDisable(true);
        seconds.setDisable(true);
    }
}