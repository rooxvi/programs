package io.ravi.exercise;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.PartETag;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CephMultipartUploader {
    private static final long PART_SIZE = 10 * 1024 * 1024; // 10 MB part size
    private static final int THREAD_POOL_SIZE = 5;

    public static void uploadFileToCeph(String bucketName, String objectKey, File file) throws Exception {
        AmazonS3 s3Client = AmazonS3ClientBuilder.defaultClient();
        String uploadId = s3Client.initiateMultipartUpload(new InitiateMultipartUploadRequest(bucketName, objectKey))
                                  .getUploadId();
        
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        List<PartETag> partETags = new ArrayList<>();

        long contentLength = file.length();
        try (FileInputStream fis = new FileInputStream(file)) {
            for (int partNumber = 1; (partNumber - 1) * PART_SIZE < contentLength; partNumber++) {
                final int currentPart = partNumber;
                final long startPos = (currentPart - 1) * PART_SIZE;
                final long size = Math.min(PART_SIZE, contentLength - startPos);
                executor.submit(() -> {
                    try (InputStream partStream = new FileInputStream(file)) {
                        partStream.skip(startPos);
                        UploadPartRequest uploadRequest = new UploadPartRequest()
                                .withBucketName(bucketName)
                                .withKey(objectKey)
                                .withUploadId(uploadId)
                                .withPartNumber(currentPart)
                                .withInputStream(partStream)
                                .withPartSize(size);
                        partETags.add(s3Client.uploadPart(uploadRequest).getPartETag());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            // Wait for all threads to finish
        }

        // Complete the multipart upload
        CompleteMultipartUploadRequest completeRequest = new CompleteMultipartUploadRequest(bucketName, objectKey, uploadId, partETags);
        s3Client.completeMultipartUpload(completeRequest);
    }
}
