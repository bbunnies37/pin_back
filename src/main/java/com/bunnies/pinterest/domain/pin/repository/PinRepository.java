package com.bunnies.pinterest.domain.pin.repository;

import com.bunnies.pinterest.domain.pin.entity.Pin;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface PinRepository extends MongoRepository<Pin, String> {
    List<Pin> findByTagsIn(List<String> tags);
    Pin findByPinId(String pinId);
    void deleteByPinId(String pinId);
}