package com.springboot.photozclone.web;

import com.springboot.photozclone.model.Photo;
import com.springboot.photozclone.service.PhotozService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@RestController
public class PhotozController {

    private PhotozService photozService;

    public PhotozController(PhotozService photozService) {
        this.photozService = photozService;
    }

    @GetMapping("/")
    public String Hello(){
        return "Hello World!";
    }

    @GetMapping("/photos")
    public Iterable<Photo> getPhotos(){
        return photozService.values();
    }

    @GetMapping("/photos/{id}")
    public Photo getPhoto(@PathVariable("id") Integer id){
        Photo photo = photozService.get(id);
        if(photo == null ) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return photo;
    }

    @DeleteMapping("photos/{id}")
    public void deletePhoto(@PathVariable("id") Integer id){
        Photo photo = photozService.get(id);
        if(photo == null ) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        photozService.remove(id);
    }

    @PostMapping("/photos")
    public Photo addPhoto(@RequestPart("data") MultipartFile file) throws IOException {
        return photozService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
    }
}
