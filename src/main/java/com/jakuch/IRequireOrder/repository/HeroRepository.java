package com.jakuch.IRequireOrder.repository;

import com.jakuch.IRequireOrder.model.hero.Hero;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HeroRepository extends MongoRepository<Hero, String> {
}
