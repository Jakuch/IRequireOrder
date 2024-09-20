package com.jakuch.IRequireOrder.hero.repository;

import com.jakuch.IRequireOrder.hero.model.Hero;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HeroRepository extends MongoRepository<Hero, String> {
}
