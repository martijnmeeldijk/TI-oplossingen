package ui.view;

import domain.model.Reverse;
import ui.controller.HandlerFactory;
import ui.controller.RequestHandler;

import javax.swing.*;

public class EncryptorUI {



    HandlerFactory handlerFactory = new HandlerFactory();

    String enterString = "CaesarText \nReverse";

    public void openEncryptor(){
        String out;

        try{
            String command = JOptionPane.showInputDialog(enterString);

            RequestHandler handler = handlerFactory.getHandler(command);
            out = handler.handleRequest();
        } catch(Exception e) {
            out = e.getMessage();
        }

        JOptionPane.showMessageDialog(null, out);
    }
}
