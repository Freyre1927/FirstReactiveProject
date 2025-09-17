    package com.freyr.reactive.controller;

    import com.freyr.reactive.model.Dish;
    import com.freyr.reactive.service.IDishService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.MediaType;
    import org.springframework.http.ResponseEntity;
    import org.springframework.http.server.reactive.ServerHttpRequest;
    import org.springframework.web.bind.annotation.*;
    import reactor.core.publisher.Flux;
    import reactor.core.publisher.Mono;

    import java.net.URI;

    @RestController
    @RequestMapping("/api/dishes")
    public class DishController {

        private final IDishService service;
        @Autowired
        public DishController(IDishService iDishService){
            this.service = iDishService;
        }
        @GetMapping("/{id}")
        public Mono<ResponseEntity<Dish>> findById(@PathVariable String id){
            return service.findById(id)
                    .map(dish -> ResponseEntity.ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(dish))
                    .defaultIfEmpty(ResponseEntity.notFound().build());
        }


        @GetMapping
        public Mono<ResponseEntity<Flux<Dish>>> findAll(){
            Flux<Dish> fx = service.findAll();
            return Mono.just(ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(fx))
                    .defaultIfEmpty(ResponseEntity.noContent().build());
        }

        @PostMapping
        public Mono<ResponseEntity<Dish>> save(@RequestBody Dish dish, final ServerHttpRequest req){
            return service.save(dish)
                    .map(ent -> ResponseEntity.created(URI.create(req.getURI().toString().concat("/").concat(dish.getId())))
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(ent)
                    );
        }

        @PutMapping("/{id}")
        public Mono<ResponseEntity<Dish>> update(@PathVariable String id,@RequestBody Dish dish){
            dish.setId(id);
            Mono<Dish> body = Mono.just(dish);
            Mono<Dish> monoDB = service.findById(id);
            return monoDB.zipWith(body , (db, req) -> {
                db.setId(req.getId());
                db.setName(req.getName());
                db.setPrice(req.getPrice());
                db.setStatus(req.getStatus());
                return db;
            })
                    .flatMap(service::update)//e-> service.update(e)
                    .map(ent -> ResponseEntity.ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(ent))
                    .defaultIfEmpty(ResponseEntity.notFound().build());
        }
        @DeleteMapping("/{id}")
        public Mono<ResponseEntity<Void>> delete(@PathVariable String id){
            return service.findById(id)
                    .flatMap(ent -> service.delete(ent.getId())
//                            .then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT))))
                            .thenReturn(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)))
                    .defaultIfEmpty(ResponseEntity.notFound().build());
        }

    }
