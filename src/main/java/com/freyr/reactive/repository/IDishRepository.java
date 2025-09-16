package com.freyr.reactive.repository;

import com.freyr.reactive.model.Dish;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IDishRepository extends ReactiveMongoRepository<Dish,String> {
}
