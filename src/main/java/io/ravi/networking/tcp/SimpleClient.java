package io.ravi.networking.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SimpleClient {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int port = 12345;

        try (Socket socket = new Socket(serverAddress, port);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            String serverResponse = input.readLine();
            System.out.println("Server says: " + serverResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
