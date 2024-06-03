package com.springboot.photozclone.service;

import com.springboot.photozclone.model.Photo;
import com.springboot.photozclone.repository.PhotozRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class PhotozService {

    private final PhotozRepository photozRepository;

//    private Map<String, Photo> db = new HashMap<>(){{
//        put("1", new Photo("1", "hello.jpg"));
//        put("2", new Photo("2", "hello-123.jpg"));
//    }};

    public PhotozService(PhotozRepository photozRepository) {
        this.photozRepository = photozRepository;
    }

    public Iterable<Photo> values() {
        return photozRepository.findAll();
    }


    public Photo get(Integer id) {
        return photozRepository.findById(id).orElse(null);
    }

    public void remove(Integer id) {
        photozRepository.deleteById(id);
    }

    public Photo save(String fileName, String contentType, byte[] data) {
        Photo photo = new Photo();
        photo.setContentType(contentType);
        photo.setFileName(fileName);
        photo.setData(data);
        photozRepository.save(photo);
        return photo;
    }
}
