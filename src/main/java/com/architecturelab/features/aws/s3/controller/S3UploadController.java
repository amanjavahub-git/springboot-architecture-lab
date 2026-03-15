package com.architecturelab.features.aws.s3.controller;

import com.amazonaws.services.s3.AmazonS3;
import com.architecturelab.features.aws.s3.model.Employee;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/s3")
@Tag(name = "S3 Upload", description = "Endpoints for uploading Employee JSON and files to AWS S3")
public class S3UploadController {

    @Autowired
    private AmazonS3 amazonS3;

    private final String bucketName = "skybridge-employee";

    // 1. Upload Employee object as JSON
    @PostMapping("/uploadEmployee")
    @Operation(
            summary = "Upload Employee JSON",
            description = "Uploads an Employee object as JSON into the S3 bucket under 'employees/' folder"
    )
    public String uploadEmployee(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Employee object containing id, name, and department"
            )
            @RequestBody Employee employee) throws IOException {
        String key = "employees/" + employee.getId() + ".json";
        String json = "{ \"id\":\"" + employee.getId() + "\", \"name\":\"" + employee.getName() + "\", \"department\":\"" + employee.getDepartment() + "\" }";

        amazonS3.putObject(bucketName, key, json);
        return "Employee uploaded successfully with key: " + key;
    }

    // 2. Upload a file (CSV, Excel, etc.)

    @PostMapping(value = "/uploadFile", consumes = "multipart/form-data")
    @Operation(
            summary = "Upload File",
            description = "Uploads a CSV, Excel, or any file into the S3 bucket under 'files/' folder"
    )
    public String uploadFile(
            @Parameter(
                    description = "File to upload (CSV, Excel, etc.)",
                    required = true,
                    content = @Content(
                            mediaType = "multipart/form-data",
                            schema = @Schema(type = "string", format = "binary")
                    )
            )
            @RequestParam("file") MultipartFile file) {
        try {
            String key = "files/" + file.getOriginalFilename();
            amazonS3.putObject(bucketName, key, file.getInputStream(), null);
            return "File uploaded successfully with key: " + key;
        } catch (Exception e) {
            throw new RuntimeException("Error uploading file to S3: " + e.getMessage(), e);
        }
    }

}