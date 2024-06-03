package com.springboot.photozclone.repository;

import com.springboot.photozclone.model.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotozRepository extends CrudRepository<Photo, Integer> {

}
