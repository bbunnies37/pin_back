package com.bunnies.pinterest.domain.reply.repository;

import com.bunnies.pinterest.domain.reply.entity.Reply;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReplyRepository extends MongoRepository<Reply, String> {
    // Optional<Reply> findByEmail(String email);

}
