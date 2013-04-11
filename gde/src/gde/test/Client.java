package gde.test;

import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = null;
        PrintWriter out = null;

        try {
            socket = new Socket("localhost", 8746);
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (UnknownHostException e) {
            System.err.println("Could not find host");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Could not retrieve output stream from socket");
            System.exit(1);
        }
        
        String json = "{\"gameId\": \"5165e9fb0364836086aa17ed\", \"identifier\": \"Asteloth\", \"data\":{\"strength\": 20, \"vitality\": 10}}";
        out.write(json);
        out.flush();

        out.close();
        socket.close();
    }
}