package com.bunnies.pinterest.domain.reply.service;


import com.bunnies.pinterest.domain.reply.dto.CreateReplyRequestDto;
import com.bunnies.pinterest.domain.reply.entity.Reply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReplyService {

    //Page<Reply> findReplyList(Pageable pageable);
    //Reply findReplybyReplyId(String replyId);

    String createReply(CreateReplyRequestDto replyEequestDto);
}

