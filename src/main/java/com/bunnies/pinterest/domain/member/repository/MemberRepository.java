package com.bunnies.pinterest.domain.member.repository;

import com.bunnies.pinterest.domain.member.entity.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends MongoRepository<Member, String> {
    Optional<Member> findByEmail(String email);
    List<Member> findAllByEmailIdIn(List<String> memberEmailIds);

    Optional<Member> findByEmailId(String emailId);
}
