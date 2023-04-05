package com.bunnies.pinterest.domain.follow.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Getter
@Builder
@Document("follow")
public class Follow {
    @Id
    private String id;

    private String fromMemberEmailId;

    private String toMemberEmailId;

    @Builder
    public Follow(String id, String fromMemberEmailId, String toMemberEmailId) {
        this.id = id;
        this.fromMemberEmailId = fromMemberEmailId;
        this.toMemberEmailId = toMemberEmailId;
    }
}
