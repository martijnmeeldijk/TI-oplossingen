package ui.controller;

import java.lang.reflect.InvocationTargetException;

public class HandlerFactory {
    public RequestHandler getHandler(String command){
        if (command == null || command.isEmpty()) return null;

        RequestHandler handler = null;

        try {
            Class handlerClass = Class.forName("ui.controller." + command + "Handler");
            Object handlerObject = handlerClass.getConstructor().newInstance();
            handler = (RequestHandler) handlerObject;
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException | SecurityException e){
            throw new RuntimeException("The requested cypher could not be found");
        }
        return handler;
    }


}
