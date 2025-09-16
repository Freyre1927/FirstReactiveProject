package com.freyr.reactive.service.impl;

import com.freyr.reactive.model.Dish;
import com.freyr.reactive.repository.IDishRepository;
import com.freyr.reactive.service.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DishServiceImpl implements IDishService {

    @Autowired
    private IDishRepository dishRepository;
    @Override
    public Mono<Dish> save(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    public Mono<Dish> update(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    public Flux<Dish> findAll() {
        return dishRepository.findAll();
    }

    @Override
    public Mono<Dish> findById(String id) {
        return dishRepository.findById(id);
    }

    @Override
    public Mono<Void> delete(String id) {
        return dishRepository.deleteById(id);
    }
}
