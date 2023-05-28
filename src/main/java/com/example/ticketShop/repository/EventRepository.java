package com.example.ticketShop.repository;

import com.example.ticketShop.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
// CrudRepository<entity class, type of primary id>
// CrudRepository -> PagingAndSortingRepository -> JpaRepository
public interface EventRepository extends JpaRepository<Event, Integer> {

}
