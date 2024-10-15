package io.ravi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;

public class App {
    public static void main(String[] args) throws IOException {

        URL google = new URL("https://www.google.com");
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address);
   /*     try (InputStreamReader googleInput = new InputStreamReader(google.openStream());
             BufferedReader googleReader = new BufferedReader(googleInput);
             BufferedWriter googleOutput = new BufferedWriter(new FileWriter("src/main/resources/google.txt"))) {
            String line;
            while ((line = googleReader.readLine()) != null) {
               googleOutput.write(line);
            }
        } catch (Exception e) {
             e.printStackTrace();
        }*/

/*
        try (InputStreamReader googleInput = new InputStreamReader(google.openStream());
             BufferedReader googleReader = new BufferedReader(googleInput);
             BufferedWriter googleOutput = new BufferedWriter(new FileWriter("src/main/resources/google.txt"))) {
            int line;
            while ((line = googleReader.read()) != -1) {
                System.out.println(line+" ~ "+(char)line);
            }
        } catch (Exception e) {

        }
*/

        try (InputStream googleInput = new FileInputStream("src/main/resources/google.txt")) {
            int line = -1;
            while ((line = googleInput.read()) != -1) {
                System.out.println(line+" > "+(char)line);
            }
        } catch (Exception e) {

        }


        System.out.println("Done....");
    }
}
