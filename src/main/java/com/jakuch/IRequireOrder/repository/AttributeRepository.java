package com.jakuch.IRequireOrder.repository;

import com.jakuch.IRequireOrder.model.Attributes;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AttributeRepository extends MongoRepository<Attributes, String> {
}
