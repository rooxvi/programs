package io.ravi.networking.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public void start(final int portNumber, Scanner scanner) {
        try (Socket socket = new Socket("localhost", portNumber);
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));){
            System.out.println("Socket created.....");
            for (String userInput; !(userInput = scanner.nextLine()).isEmpty(); ) {
                writer.println(userInput);
                System.out.println("Received: " + reader.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}