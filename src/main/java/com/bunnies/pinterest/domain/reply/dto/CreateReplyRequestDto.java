package com.bunnies.pinterest.domain.reply.dto;

import com.bunnies.pinterest.domain.reply.entity.Reply;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateReplyRequestDto {
    private String replyId;
    private String pinId;
    private String targetReplyId;
    private String userId;
    private String replyVal;
    private int likeNum = 0;

    public Reply toEntity() {
        return Reply.builder()
                .replyId(replyId)
                .pinId(pinId)
                .targetReplyId(targetReplyId)
                .userId(userId)
                .replyVal(replyVal)
                .likeNum(likeNum)
                .build();
    }
}
