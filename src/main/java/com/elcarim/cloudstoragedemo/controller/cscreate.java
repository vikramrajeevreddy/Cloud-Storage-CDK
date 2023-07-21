package com.elcarim.cloudstoragedemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

@RestController
@RequestMapping("/connect")
public class cscreate {
    @GetMapping
    public String getHelloWorld(){

        // Instantiates a client
        Storage storage = StorageOptions.getDefaultInstance().getService();

        // The name for the new bucket
        //String bucketName = "elcarim-test-bucket"; // "my-new-bucket";

        // Creates the new bucket
        //Bucket bucket = storage.create(BucketInfo.of(bucketName));

        //System.out.printf("Bucket %s created.%n", bucket.getName());
        return "Created the Cloud Storage bucket " + storage;
    }
}
