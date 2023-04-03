package com.example.goodsservice.service;

import com.example.goodsservice.exp.GoodNotFoundException;
import com.example.goodsservice.model.GoodEntity;
import com.example.goodsservice.repositories.GoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.UUID;

@RequiredArgsConstructor

@Service
public class GoodService {

    private final GoodRepository repository;

    @PostConstruct
    public void init(){
        var good1 = GoodEntity.builder()
                .id(UUID.randomUUID())
                .name("book")
                .build();

        var good2 = GoodEntity.builder()
                .id(UUID.randomUUID())
                .name("pen")
                .build();

        repository.save(good1);
        repository.save(good2);
    }

    public GoodEntity getByName(String name){
        return repository.findByName(name).
                orElseThrow(() -> new GoodNotFoundException("Good with name " + name + " not found"));
    }
}
