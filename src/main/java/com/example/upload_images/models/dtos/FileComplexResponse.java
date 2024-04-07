package com.example.upload_images.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FileComplexResponse {

    private String response;
    private BaseResponse baseResponse;
}
