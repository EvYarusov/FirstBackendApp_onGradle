package com.example.firstBackendApp_onGradle.events;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
// CrudRepository<entity class, type of primary id>
public interface EventRepository extends CrudRepository<Event, Integer> {

}
