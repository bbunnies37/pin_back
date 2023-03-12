package com.bunnies.pinterest.domain.reply.dto;

import com.bunnies.pinterest.domain.reply.entity.Reply;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReadReplyResponseDto {
    private String replyId;
    private String pinId;
    private String targetReplyId;
    private String userId;
    private String replyVal;
    private int likeNum;

    public ReadReplyResponseDto(Reply reply) {

        this.replyId = reply.getReplyId();
        this.pinId = reply.getPinId();
        this.targetReplyId = reply.getTargetReplyId();
        this.userId = reply.getUserId();
        this.replyVal = reply.getReplyVal();
        this.likeNum = reply.getLikeNum();

    }
}

