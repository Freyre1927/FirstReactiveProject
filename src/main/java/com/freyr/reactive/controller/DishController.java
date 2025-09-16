    package com.freyr.reactive.controller;

    import com.freyr.reactive.model.Dish;
    import com.freyr.reactive.service.IDishService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;
    import reactor.core.publisher.Flux;
    import reactor.core.publisher.Mono;

    @RestController
    @RequestMapping("/api/dishes")
    public class DishController {

        @Autowired
        private IDishService service;

        @GetMapping("/{id}")
        public Mono<Dish> findById(@PathVariable String id){
            return service.findById(id);
        }


        @GetMapping
        public Flux<Dish> findAll(){
            return service.findAll();
        }

        @PostMapping
        public Mono<Dish> save(@RequestBody Dish dish){
            System.out.println("dish =>" + dish);
            return service.save(dish);
        }

        @PutMapping
        public Mono<Dish> update(@RequestBody Dish dish){
            return service.save(dish);
        }
        @DeleteMapping("/{id}")
        public Mono<Void> delete(@PathVariable String id){
            return service.delete(id);
        }

    }
