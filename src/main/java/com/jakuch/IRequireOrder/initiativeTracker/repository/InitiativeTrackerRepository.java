package com.jakuch.IRequireOrder.initiativeTracker.repository;

import com.jakuch.IRequireOrder.initiativeTracker.model.InitiativeTracker;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InitiativeTrackerRepository extends MongoRepository<InitiativeTracker, String> {
}
