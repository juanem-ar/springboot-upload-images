package com.example.upload_images.services;

import org.springframework.web.multipart.MultipartFile;

public interface IFileService {
    String handleUploadFile(MultipartFile file, Long id) throws Exception;
}
