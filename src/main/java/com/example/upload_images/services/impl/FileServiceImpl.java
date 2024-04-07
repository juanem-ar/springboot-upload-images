package com.example.upload_images.services.impl;

import com.example.upload_images.services.IFileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
@Slf4j
public class FileServiceImpl implements IFileService {
    @Override
    public String handleUploadFile(MultipartFile file, Long id) throws Exception {
        try{
            byte[] bytes = file.getBytes();
            String newFileName = getString(file);

            File folder = new File("src/main/resources/assets/rental-units-img/" + id + "/");
            if (!folder.exists()){
                folder.mkdirs();
            }

            Path path = Paths.get("src/main/resources/assets/rental-units-img/"+ id + "/" + newFileName);

            Files.write(path, bytes);
            return "File upload successfully";
        }catch (Exception e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @NotNull
    private static String getString(MultipartFile file) throws BadRequestException {

        String fileNameExtension = getFileNameExtension();

        String fileOriginalName = getFileOriginalName(file);

        String fileFormat = fileOriginalName.substring(fileOriginalName.lastIndexOf("."));
        String fileName = fileOriginalName.substring(0, fileOriginalName.lastIndexOf("."));

        return fileName + "_" + fileNameExtension + fileFormat;
    }

    @NotNull
    private static String getFileNameExtension() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss-SSS");
        return now.format(formatter);
    }

    @NotNull
    private static String getFileOriginalName(MultipartFile file) throws BadRequestException {
        String fileOriginalName = file.getOriginalFilename();

        long fileSize = file.getSize();
        long maxFileSize = 5 * 1024 * 1024;

        if (fileSize > maxFileSize){
            throw new BadRequestException("File size must be less or equal 5 mb");
        }

        if (
                !fileOriginalName.endsWith(".jpg") &&
                !fileOriginalName.endsWith(".jpeg") &&
                !fileOriginalName.endsWith(".png")
        ){
            throw new BadRequestException("Only JPG, JPEG, PNG files are allowed");
        }
        return fileOriginalName;
    }
}
