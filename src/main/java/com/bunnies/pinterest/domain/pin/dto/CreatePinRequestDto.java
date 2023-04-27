package com.bunnies.pinterest.domain.pin.dto;

import com.bunnies.pinterest.domain.pin.entity.Pin;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class CreatePinRequestDto {

    private String pinId;
    private String userId;
    private String title;
    private String description;
    private String imageUrl;
    private List<String> tags;


    public Pin toEntity() {
        return Pin.builder()
                .pinId(pinId)
                .userId(userId)
                .title(title)
                .description(description)
                .imageUrl(imageUrl)
                .tags(tags)
                .build();
    }
}
