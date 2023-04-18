package com.bunnies.pinterest.domain.category.entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Getter
@Document("category")
public class Category {

    @Id
    private String id;

    private String categoryName;

    private String thumbNail;

}
