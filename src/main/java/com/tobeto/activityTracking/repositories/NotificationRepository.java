package com.tobeto.activityTracking.repositories;

import com.tobeto.activityTracking.entities.Notification;
import com.tobeto.activityTracking.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {

    List<Notification> findByRecipient(User recipient);
}
