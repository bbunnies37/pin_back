package com.bunnies.pinterest.domain.reply.service;

import com.bunnies.pinterest.domain.reply.entity.Reply;
import com.bunnies.pinterest.domain.reply.repository.ReplyRepository;
import com.bunnies.pinterest.domain.reply.dto.CreateReplyRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.management.Query;

@RequiredArgsConstructor
@Service
public class ReplyServiceImpl implements ReplyService {
    private final ReplyRepository ReplyRepository;

    @Override
    public String createReply(CreateReplyRequestDto requestDto) {
        ReplyRepository.save(requestDto.toEntity());
        return null;
    }

}
