package io.ravi.networking.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public void start(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            try {
                ExecutorService executorService = Executors.newCachedThreadPool();
                while (true) {
                    Socket clientConn = serverSocket.accept();
                    executorService.submit(() -> {
                        // Accept the client request for communication
                        String clientIp = clientConn.getInetAddress().getHostAddress();
                        int clientPort = clientConn.getPort();
                        System.out.println("Connected : " + clientIp + ":" + clientPort);
                        try (BufferedReader clientReader = new BufferedReader(new InputStreamReader(clientConn.getInputStream()));
                             PrintWriter clientWriter = new PrintWriter(clientConn.getOutputStream(), true)) {

                            for (String inputLine; (inputLine = clientReader.readLine()) != null; ) {
                                System.out.println(clientIp + ":" + clientPort + " -> " + inputLine);
                                clientWriter.println(new StringBuffer(inputLine).reverse());
                            }

                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}