package com.bunnies.pinterest.domain.follow.repository;

import com.bunnies.pinterest.domain.follow.entity.Follow;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FollowRepository extends MongoRepository<Follow, String> {
    List<Follow> findAllByFromMemberEmailId(String memberEmailId);

    List<Follow> findAllByToMemberEmailId(String memberEmailId);

}
