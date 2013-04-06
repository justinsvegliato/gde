package gde.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SocketUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(SocketUtils.class);

    private SocketUtils() {
        throw new AssertionError();
    }

    public static void close(ServerSocket serverSocket) {
        try {
            if (serverSocket != null && !serverSocket.isClosed()) {
                LOGGER.debug("Attempting to close the ServerSocket");
                serverSocket.close();
                LOGGER.debug("Closed the ServerSocket");
            }
        } catch (IOException ioe) {
            LOGGER.debug("IOException encountered while trying to close the ServerSocket", ioe);
        }
    }

    public static void close(Socket socket) {
        try {
            if (socket != null && !socket.isClosed()) {
                LOGGER.debug("Attempting to close the Socket");
                socket.close();
                LOGGER.debug("Closed the Socket");
            }
        } catch (IOException ioe) {
            LOGGER.debug("IOException encountered while trying to close the Socket", ioe);
        }
    }

    public static void close(InputStream inputStream) {
        try {
            if (inputStream != null) {
                LOGGER.debug("Attempting to close the InputStream");
                inputStream.close();
                LOGGER.debug("Closed the InputStream");
            }
        } catch (IOException ioe) {
            LOGGER.debug("IOException encountered while trying to close the InputStream", ioe);
        }
    }

    public static void close(BufferedReader bufferedReader) {
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
                LOGGER.debug("Closed the BufferedReader");
            }
        } catch (IOException ioe) {
            LOGGER.debug("IOException encountered while trying to close the BufferedReader", ioe);
        }
    }
}
