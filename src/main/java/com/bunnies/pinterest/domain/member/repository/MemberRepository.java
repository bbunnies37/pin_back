package com.bunnies.pinterest.domain.member.repository;

import com.bunnies.pinterest.domain.member.entity.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MemberRepository extends MongoRepository<Member, String> {
    Optional<Member> findByEmail(String email);

}
