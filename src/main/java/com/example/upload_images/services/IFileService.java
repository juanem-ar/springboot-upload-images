package com.example.upload_images.services;

import com.example.upload_images.models.dtos.FileComplexResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IFileService {
    FileComplexResponse handleUploadFile(List<MultipartFile> fileList, Long id) throws Exception;
}
