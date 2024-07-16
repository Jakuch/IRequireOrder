package com.jakuch.IRequireOrder.repository;

import com.jakuch.IRequireOrder.model.Hero;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HeroRepository extends MongoRepository<Hero, String> {
}
