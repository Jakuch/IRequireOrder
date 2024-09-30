package com.jakuch.IRequireOrder.character.repository;

import com.jakuch.IRequireOrder.character.model.Character;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CharacterRepository extends MongoRepository<Character, String> {
}
