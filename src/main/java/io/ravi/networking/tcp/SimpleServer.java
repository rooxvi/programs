package io.ravi.networking.tcp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    public static void main(String[] args) {
        int port = 12345;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started and listening on port " + port);

            Socket clientSocket = serverSocket.accept(); // Await client connection
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            out.println("Hello from the server side!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
