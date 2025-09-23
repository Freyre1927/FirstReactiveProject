package com.freyr.reactive.service.impl;

import com.freyr.reactive.model.Client;
import com.freyr.reactive.model.Dish;
import com.freyr.reactive.repository.IClientRepository;
import com.freyr.reactive.repository.IDishRepository;
import com.freyr.reactive.repository.IGenericRepo;
import com.freyr.reactive.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl extends  CrudImpl<Client,String> implements IClientService {

    @Autowired
    private IClientRepository repository;

    @Override
    protected IGenericRepo<Client, String> getRepo() {
        return repository;
    }
}
