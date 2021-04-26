package com.sergiozella.cursomc.services;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.sergiozella.cursomc.services.exceptions.FileException;

@Service
public class S3Service {
	@Autowired
	private AmazonS3 s3client;

	@Value("${s3.region}")
	private String bucketName;

	public URI uploadFile(MultipartFile multipartFile) {

		try {
			String fileName = multipartFile.getName();
			InputStream inputStream = multipartFile.getInputStream();
			String contentType = multipartFile.getContentType();

			return this.uploadFile(inputStream, fileName, contentType);
		} catch (IOException e) {
			throw new FileException("Erro de IO" + e.getMessage());
		}

	}

	public URI uploadFile(InputStream inputStream, String fileName, String contentType) {
		try {
			ObjectMetadata meta = new ObjectMetadata();
			meta.setContentType(contentType);

			s3client.putObject(bucketName, fileName, inputStream, meta);

			return s3client.getUrl(bucketName, fileName).toURI();
		} catch (URISyntaxException e) {
			throw new FileException("Erro ao converter URL para URI");
		}
	}

}