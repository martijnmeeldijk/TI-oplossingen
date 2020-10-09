package ui.controller;

import domain.model.Reverse;

import javax.swing.*;

public class ReverseHandler extends RequestHandler {

    Reverse client = new Reverse();

    @Override
    public String handleRequest() {
        String inputString = JOptionPane.showInputDialog("Input string:");
        return client.encrypt(inputString);
    }
}
