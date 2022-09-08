package com.musalasoft.droneservice.repository;

import com.musalasoft.droneservice.model.Drone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DroneRepository extends JpaRepository<Drone,Long> {
}
