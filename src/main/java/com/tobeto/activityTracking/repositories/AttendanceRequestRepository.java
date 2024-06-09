package com.tobeto.activityTracking.repositories;

import com.tobeto.activityTracking.entities.AttendanceRequest;
import com.tobeto.activityTracking.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRequestRepository extends JpaRepository<AttendanceRequest, Integer> {

    List<AttendanceRequest> findByEvent(Event event);
}
