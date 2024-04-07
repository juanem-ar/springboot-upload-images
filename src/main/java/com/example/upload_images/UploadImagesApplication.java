package com.example.upload_images;

import com.tinify.Tinify;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UploadImagesApplication {
	@Value("${spring.tiny.env.api.key}")
	private static String tinyToken;

	public static void main(String[] args) {
		SpringApplication.run(UploadImagesApplication.class, args);
		Tinify.setKey(tinyToken);
	}

}
