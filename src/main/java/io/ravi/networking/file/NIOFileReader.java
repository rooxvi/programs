package io.ravi.networking.file;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NIOFileReader {
    public static void main(String[] args) {
        Path path = Paths.get("largefile.txt");
        try (FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ)) {
            ByteBuffer buffer = ByteBuffer.allocate(8192); // 8 KB buffer
            while (fileChannel.read(buffer) != -1) {
                buffer.flip(); // Prepare buffer for reading
                while (buffer.hasRemaining()) {
                    System.out.print((char) buffer.get()); // Process byte as character
                }
                buffer.clear(); // Clear buffer for next read
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}