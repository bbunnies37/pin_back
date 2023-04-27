package com.bunnies.pinterest.domain.pin.dto;

import com.bunnies.pinterest.domain.pin.entity.Pin;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class ReadPinResponseDto {
    private String pinId;
    private String userId;
    private String title;
    private String description;
    private String imageUrl;
    private List<String> tags;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public ReadPinResponseDto(Pin pin) {

        this.pinId = pin.getPinId();
        this.userId = pin.getUserId();
        this.title = pin.getTitle();
        this.description = pin.getDescription();
        this.imageUrl = pin.getImageUrl();
        this.tags = pin.getTags();
        this.createdDate = pin.getCreatedDate();
        this.modifiedDate = pin.getModifiedDate();

    }
}

