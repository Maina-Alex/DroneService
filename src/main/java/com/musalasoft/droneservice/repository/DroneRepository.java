package com.musalasoft.droneservice.repository;

import com.musalasoft.droneservice.constants.DroneState;
import com.musalasoft.droneservice.model.Drone;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DroneRepository extends JpaRepository<Drone,Long> {
    List<Drone> findAllByState(DroneState droneState,Pageable pageable);
}
