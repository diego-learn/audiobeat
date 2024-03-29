package com.br.audiobeatapi.component;


import com.br.audiobeatapi.dto.FileDto;
import com.br.audiobeatapi.exception.BadRequestException;
import com.br.audiobeatapi.exception.FileWriteException;
import com.br.audiobeatapi.exception.GCPFileUploadException;
import com.br.audiobeatapi.exception.InvalidFileTypeException;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@Component
public class StorageUtil {

    @Value("${gcp.config.file}")
    private String gcpConfigFile;

    @Value("${gcp.project.id}")
    private String gcpProjectId;

    @Value("${gcp.bucket.id}")
    private String gcpBucketId;

    @Value("${gcp.dir.name}")
    private String gcpDirectoryName;


    public FileDto uploadFile(MultipartFile multipartFile, String fileName, String contentType) {

        try {

            log.debug("Start file uploading process on GCS");
            byte[] fileData = FileUtils.readFileToByteArray(convertFile(multipartFile));

            InputStream inputStream = new ClassPathResource(gcpConfigFile).getInputStream();

            StorageOptions options = StorageOptions.newBuilder().setProjectId(gcpProjectId)
                    .setCredentials(GoogleCredentials.fromStream(inputStream)).build();

            Storage storage = options.getService();
            Bucket bucket = storage.get(gcpBucketId, Storage.BucketGetOption.fields());

            RandomString id = new RandomString(6, ThreadLocalRandom.current());
            Blob blob = bucket.create(gcpDirectoryName + "/" + fileName + "-" + id.nextString() + checkFileExtension(fileName), fileData, contentType);

            if (blob != null) {
                log.debug("File successfully uploaded to GCS");
                return new FileDto(blob.getName(), blob.getMediaLink());
            }

        } catch (Exception e) {
            log.error("An error occurred while uploading data. Exception: ", e);
            throw new GCPFileUploadException("An error occurred while storing data to GCS");
        }
        throw new GCPFileUploadException("An error occurred while storing data to GCS");
    }

    private File convertFile(MultipartFile file) {

        try {
            if (file.getOriginalFilename() == null) {
                throw new BadRequestException("Original file name is null");
            }
            File convertedFile = new File(file.getOriginalFilename());
            FileOutputStream outputStream = new FileOutputStream(convertedFile);
            outputStream.write(file.getBytes());
            outputStream.close();
            log.debug("Converting multipart file : {}", convertedFile);
            return convertedFile;
        } catch (Exception e) {
            throw new FileWriteException("An error has occurred while converting the file");
        }
    }

    private String checkFileExtension(String fileName) {
        if (fileName != null && fileName.contains(".")) {
            String[] extensionList = {".png", ".jpeg", ".pdf", ".doc", ".mp3"};

            for (String extension : extensionList) {
                if (fileName.endsWith(extension)) {
                    log.debug("Accepted file type : {}", extension);
                    return extension;
                }
            }
        }
        log.error("Not a permitted file type");
        throw new InvalidFileTypeException("Not a permitted file type");
    }


}
