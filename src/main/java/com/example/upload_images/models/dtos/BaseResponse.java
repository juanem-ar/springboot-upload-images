package com.example.upload_images.models.dtos;

public record BaseResponse(String[] errorMessage) {
    public boolean hastErrors(){
        return errorMessage != null && errorMessage.length > 0;
    }
}
