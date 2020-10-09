package ui.controller;

import domain.model.CaesarText;

import javax.swing.*;

public class CaesarTextHandler extends RequestHandler {
    CaesarText client = new CaesarText();

    @Override
    public String handleRequest() {
        String command = JOptionPane.showInputDialog("1.encrypt \n2. decrypt");
        String inputString = JOptionPane.showInputDialog("Input string:");

        String out;
        switch(command){
            case("1"):
                out = client.encrypt(inputString);
                break;
            case("2"):
                out = client.decrypt(inputString);
                break;
            default:
                out = "Could not decrypt";
        }

        return out;

    }
}
