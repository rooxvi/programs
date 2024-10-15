package io.ravi.exercise;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CephUploader {

    private static final int PART_SIZE = 50 * 1024 * 1024; // 50MB
    
    public void uploadFilesInParallel(File directory) {
        ExecutorService executor = Executors.newFixedThreadPool(4); // Adjust thread count based on CPU and network

        for (File file : directory.listFiles()) {
            executor.submit(() -> multipartUpload(file));
        }
        executor.shutdown();
    }

    private void multipartUpload(File file) {
        try {
            // Initiate Multipart upload (using Ceph S3 or RADOS)
            // Split file into parts and upload in parallel
            // Example code for multipart upload here
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        ExecutorService groupExecutor = Executors.newFixedThreadPool(3); // For multiple directories
        
        File[] directories = new File("/path/to/parent/dir").listFiles(File::isDirectory);
        for (File dir : directories) {
            groupExecutor.submit(() -> new CephUploader().uploadFilesInParallel(dir));
        }
        
        groupExecutor.shutdown();
    }
}
