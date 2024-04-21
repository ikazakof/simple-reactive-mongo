package com.example.webflux.repository;

import com.example.webflux.entity.Item;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface ItemRepository extends ReactiveMongoRepository<Item, String> {

    Mono<Item> findByName(String name);

}
