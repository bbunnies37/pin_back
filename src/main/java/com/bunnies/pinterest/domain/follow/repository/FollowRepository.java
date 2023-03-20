package com.bunnies.pinterest.domain.follow.repository;

import com.bunnies.pinterest.domain.follow.entity.Follow;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FollowRepository extends MongoRepository<Follow, String> {
    List<Follow> findAllByFromMemberEmail(String memberEmail);

    List<Follow> findAllByToMemberEmail(String memberEmail);

}
