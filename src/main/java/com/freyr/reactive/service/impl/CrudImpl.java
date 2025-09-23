package com.freyr.reactive.service.impl;

import com.freyr.reactive.repository.IGenericRepo;
import com.freyr.reactive.service.ICrud;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public abstract class CrudImpl<T,ID> implements ICrud<T,ID> {

    protected  abstract IGenericRepo<T,ID> getRepo();

    @Override
    public Mono<T> save(T t) {
        return getRepo().save(t);
    }

    @Override
    public Mono<T> update(T t) {
        return getRepo().save(t);
    }

    @Override
    public Flux<T> findAll() {
        return getRepo().findAll();
    }

    @Override
    public Mono<T> findById(ID id) {
        return getRepo().findById(id);
    }

    @Override
    public Mono<Void> delete(ID id) {
        return getRepo().deleteById(id);
    }
}
