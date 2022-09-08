package com.musalasoft.droneservice.repository;

import com.musalasoft.droneservice.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery,Long> {
}
