package io.ravi.networking.learn;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class HttpClient {

    public static void main(String[] args) throws IOException {
        String url = "https://google.com";
        String filePath = "Google.html"; ///Users/ravichandran/git/my_repo/programs/src/main/java/io/ravi/networking/learn/HttpClient.java
        URL urlObj = new URL(url);
        URLConnection urlCon = urlObj.openConnection();
        try (InputStream inputStream = urlCon.getInputStream();
             BufferedInputStream reader = new BufferedInputStream(inputStream);
             BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(filePath));) {

            byte[] buffer = new byte[4096];
            int bytesRead = -1;

            while ((bytesRead = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, bytesRead);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}