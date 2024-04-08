package com.example.projectapi.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.io.IOException;

public class PdfController {




    @GetMapping("/download/pdf")
    public ResponseEntity<Resource> downloadPdf() throws IOException {
        // Load the PDF file from the classpath
        Resource resource = new ClassPathResource("Downloads");

        // If the file doesn't exist, handle the error accordingly
        if (!resource.exists()) {
            throw new RuntimeException("PDF file not found");
        }

        // Set the appropriate content type for PDF
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);

        // Set the filename in the content disposition header
        headers.setContentDispositionFormData("attachment", "file.pdf");

        // Return the ResponseEntity with the PDF file and headers
        return ResponseEntity.ok()
                .headers(headers)
                .body(resource);
    }
}
