package com.example.philosophermultithred;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableStringValue;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

import java.util.ArrayList;

public class UILogger {
    private final StringProperty log = new SimpleStringProperty("");

    public UILogger(StringProperty log) {
        log.bind(this.log);
    }

    public void log(Action action, int philosopherId) {
        log.setValue(
                log.getValue() + "\n" +
                "PHILOSOPHER_ID: " + philosopherId
                + " ACTION: " + action.getAction().name()
                + " TIME: " + action.getNanoTime());
        System.out.println("logged");
    }
}
