package com.bunnies.pinterest.domain.category.repository;

import com.bunnies.pinterest.domain.category.entity.Category;
import com.bunnies.pinterest.domain.follow.entity.Follow;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {

}
