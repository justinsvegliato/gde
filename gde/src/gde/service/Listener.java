package gde.service;

import gde.service.util.SocketUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Listener {

    private static final Logger LOGGER = LoggerFactory.getLogger(Listener.class);
    private static final int LOCAL_PORT = 8746;

//    static {
//        InputStream inputStream = Listener.class.getClassLoader().getResourceAsStream("resources/listener.properties");
//        Properties listenerProperties = new Properties();
//        try {
//            listenerProperties.load(inputStream);
//            LOCAL_PORT = Integer.parseInt(listenerProperties.getProperty("LOCAL_PORT"));            
//        } catch (IOException e) {
//            System.exit(1);
//        } finally {
//            SocketUtils.close(inputStream);
//        }
//    }
    
    private Listener() {
    }

    public static void main(String[] args) {
        listen();
    }

    private static void listen() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(LOCAL_PORT);
            LOGGER.debug("Opened ServerSocket on port [" + LOCAL_PORT + "]");
        } catch (IOException ioe) {
            LOGGER.error("Failed to open ServerSocket on port [" + LOCAL_PORT + "]", ioe);
            return;
        }

        Socket clientSocket = null;
        BufferedReader bufferedReader = null;
        RequestHandler requestHandler = new RequestHandler();
        try {
            LOGGER.debug("Initialized and ready to receive messages from game client");
            String clientRequest;
            while (true) {
                clientSocket = serverSocket.accept();
                LOGGER.debug("Established a connection with the game client");
                bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                while ((clientRequest = bufferedReader.readLine()) != null) {
                    LOGGER.debug("Received a request from the game client");
                    requestHandler.handleRequest(clientRequest);
                }
            }
        } catch (IOException e) {
            LOGGER.error("Encountered IOException while working with the ServerSocket or ClientSocket", e);
        } catch (Throwable t) {
            LOGGER.error("Caught Throwable for logging purposes", t);
        } finally {
            SocketUtils.close(bufferedReader);
            SocketUtils.close(clientSocket);
            SocketUtils.close(serverSocket);
        }
    }
}