package com.example.lullaby;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.System.exit;

public class LullabyController {


    public TextField hours;
    public TextField minutes;
    public TextField seconds;
    public Button sleepButton;
    public Button hibernateButton;
    public Button rebootButton;
    public Button shutdownButton;
    public int counter;
    Timer timer = new Timer();
    Runtime run = Runtime.getRuntime();

    public void GoToSleep(ActionEvent event) {
        calculateSeconds();
        switchOffTextfields();
        while (counter > 0){
            timer.scheduleAtFixedRate(tick, 0, 1000);
        }
        try {
            run.exec("RUNDLL32.EXE powrprof.dll,SetSuspendState 0,1,0");
        } catch (IOException e) {
            e.printStackTrace();
        }
        exit(0);
    }

    public void Hibernate(ActionEvent event) {
        calculateSeconds();
        switchOffTextfields();
        while (counter > 0){
            timer.scheduleAtFixedRate(tick, 0, 1000);
        }
        try {
            run.exec("shutdown/h /t 0");
        } catch (IOException e) {
            e.printStackTrace();
        }
        exit(0);
    }

    public void Restart(ActionEvent event) {
        calculateSeconds();
        switchOffTextfields();
        while (counter > 0){
            timer.scheduleAtFixedRate(tick, 0, 1000);
        }
        try {
            run.exec("shutdown /r");
        } catch (IOException e) {
            e.printStackTrace();
        }
        exit(0);
    }

    public void SwitchOff(ActionEvent event) {
        calculateSeconds();
        switchOffTextfields();
        while (counter > 0){
            timer.scheduleAtFixedRate(tick, 0, 1000);
        }
        try {
            run.exec("shutdown /s");
        } catch (IOException e) {
            e.printStackTrace();
        }
        exit(0);
    }

    private void switchOffTextfields(){
        hours.setDisable(true);
        minutes.setDisable(true);
        seconds.setDisable(true);
    }

    TimerTask tick = new TimerTask() {
        @Override
        public void run() {
            hours.setText(String.valueOf(counter / 3600));
            minutes.setText(String.valueOf((counter % 3600) /60));
            seconds.setText(String.valueOf((counter % 3600) % 60));
            counter = counter - 1;
        }
    };


    private void calculateSeconds(){
        counter += Integer.parseInt(seconds.getText());
        counter += Integer.parseInt(minutes.getText()) * 60;
        counter += Integer.parseInt(hours.getText()) * 60 * 60;
    }

}
