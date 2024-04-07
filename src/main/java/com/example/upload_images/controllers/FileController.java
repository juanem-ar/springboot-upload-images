package com.example.upload_images.controllers;

import com.example.upload_images.services.IFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/files")
public class FileController {
    private final IFileService iFileService;

    @PostMapping("/rental-units/{id}")
    public ResponseEntity<String> uploadFile(@RequestParam("files") MultipartFile file, @PathVariable Long id) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(iFileService.handleUploadFile(file, id));
    }
}
