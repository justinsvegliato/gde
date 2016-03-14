package gde.test;

import java.io.*;
import java.net.*;

/**
 * The Client class merely serves to test the functionality of the Listener class.
 * It essentially creates a connection with the Listener object and thereafter 
 * sends requests.
 * 
 * @author Justin Svegliato and Andrew Evans
 */
public class Client {

    /**
     * Checks if the Listener object is working properly by instantiating a
     * connection and then sending a single request.
     */
    public static void main(String[] args) throws IOException {
        Socket socket;
        PrintWriter out;
        for (int i = 0; i < 2; i++) {
            socket = new Socket("10.10.58.192", 8746);
            out = new PrintWriter(socket.getOutputStream(), true);
            String json = "{\"gameId\": \"5165e9fb0364836086aa17ed\", \"identifier\": \"Asteloth\", \"data\":{\"strength\": 20, \"vitality\": 10}}";
            out.write(json);
            out.flush();
            out.close();
            socket.close();
        }
    }
}