package com.tobeto.activityTracking.repositories;

import com.tobeto.activityTracking.entities.Event;
import com.tobeto.activityTracking.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    List<Event> findByOwner(User owner);
}

