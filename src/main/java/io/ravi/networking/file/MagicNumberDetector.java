package io.ravi.networking.file;

import java.io.FileInputStream;
import java.io.IOException;

public class MagicNumberDetector {
    public static void main(String[] args) {
        String filePath = "src/main/resources/google.txt";
        try (FileInputStream fis = new FileInputStream(filePath)) {
            byte[] magicBytes = new byte[8]; // Read first 8 bytes
            if (fis.read(magicBytes) != -1) {
                // Convert bytes to hex
                StringBuilder hex = new StringBuilder();
                for (byte b : magicBytes) {
                    hex.append(String.format("%02X ", b));
                }
                System.out.println("Magic Number: " + hex.toString().trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}