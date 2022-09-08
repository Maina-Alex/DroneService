package com.musalasoft.droneservice.repository;

import com.musalasoft.droneservice.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeliveryRepository extends JpaRepository<Delivery,Long> {
    Optional<Delivery> findDeliveryByDroneIdAndCompletedFalseAndSoftDeleteFalse(long droneId);
}
