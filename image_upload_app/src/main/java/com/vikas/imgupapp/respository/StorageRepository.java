package com.vikas.imgupapp.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vikas.imgupapp.entity.ImageData;

import java.util.Optional;

public interface StorageRepository extends JpaRepository<ImageData,Long> {


    Optional<ImageData> findByName(String fileName);
}
