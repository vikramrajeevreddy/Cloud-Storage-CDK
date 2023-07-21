package com.elcarim.cloudstoragedemo.controller;

import com.elcarim.cloudstoragedemo.service.StorageService;
import com.google.cloud.storage.StorageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/storage")
public class StorageController {

    private final StorageService storageService;

    public StorageController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping("/bucket")
    public ResponseEntity<String> createBucket(@RequestParam String bucketName) {
        try {
            storageService.createBucket(bucketName);
            return new ResponseEntity<>("Bucket created successfully", HttpStatus.CREATED);
        } catch (StorageException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam String bucketName, @RequestParam("file") MultipartFile file) {
        try {
            storageService.uploadFile(bucketName, file);
            return new ResponseEntity<>("File uploaded successfully", HttpStatus.OK);
        } catch (StorageException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

