package com.jakuch.IRequireOrder.model.initiativeTracker.repository;

import com.jakuch.IRequireOrder.model.initiativeTracker.InitiativeTracker;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InitiativeTrackerRepository extends MongoRepository<InitiativeTracker, String> {
}
