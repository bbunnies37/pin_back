package com.bunnies.pinterest.domain.reply.service;

import com.bunnies.pinterest.domain.reply.repository.ReplyRepository;
import com.bunnies.pinterest.domain.reply.dto.CreateReplyRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReplyService {
    private final ReplyRepository ReplyRepository;

    public String createReply(CreateReplyRequestDto requestDto) {
        //requestDto.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        ReplyRepository.save(requestDto.toEntity());
        return null;
    }
}
