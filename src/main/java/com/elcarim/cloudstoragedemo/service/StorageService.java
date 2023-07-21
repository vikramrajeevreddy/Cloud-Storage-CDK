package com.elcarim.cloudstoragedemo.service;

import com.elcarim.cloudstoragedemo.exception.StorageServiceException;
import com.google.cloud.storage.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class StorageService {

    private final Storage storage;

    public StorageService() {
        this.storage = StorageOptions.getDefaultInstance().getService();
    }

    public Bucket createBucket(String bucketName) {
        try {
            // Creates a new bucket
            Bucket bucket = storage.create(BucketInfo.of(bucketName));
            return bucket;
        } catch (Exception e) {
            throw new StorageServiceException("Could not create bucket", e);
        }
    }

    public Blob uploadFile(String bucketName, MultipartFile file) {
        try {
            String blobName = UUID.randomUUID().toString();
            // The inputstream is closed by the uploader.
            BlobId blobId = BlobId.of(bucketName, blobName);
            BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType(file.getContentType()).build();
            Blob blob = storage.create(blobInfo, file.getInputStream());
            return blob;
        } catch (IOException e) {
            throw new StorageServiceException("Could not upload file", e);
        }
    }
}
