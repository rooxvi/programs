package io.ravi.networking.io;

import java.net.Socket;
import java.util.Scanner;

public class App {
    private static int portNumber = 12345;

    public static void main(String[] args) {
        System.out.println("Is this server (y/n)?");
        try (Scanner scanner = new Scanner(System.in)) {
            String yes = scanner.nextLine();
            if(yes.equalsIgnoreCase("y") || yes.equalsIgnoreCase("yes")) {
               new Server().start(portNumber);
            }else {
                new Client().start(portNumber,scanner);
            }
        }
    }
}