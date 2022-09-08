package com.musalasoft.droneservice.service;

import com.musalasoft.droneservice.model.Drone;
import com.musalasoft.droneservice.model.MedicineLoad;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Alex Maina
 * @created 08/09/2022
 **/
@Service
@RequiredArgsConstructor
public class DroneServiceImpl implements DroneService{

    @Override
    public Drone registerDrone(Drone drone) {
        throw new IllegalStateException("Operation not implemented");
    }

    @Override
    public boolean loadDrone(long droneId, List<MedicineLoad> medicineLoad) {
        throw new IllegalStateException("Operation not implemented");
    }

    @Override
    public List<MedicineLoad> checkLoadedMedication(long drone) {
        throw new IllegalStateException("Operation not implemented");
    }

    @Override
    public List<Drone> checkAvailableDrone(Pageable pageable) {
        throw new IllegalStateException("Operation not implemented");
    }

    @Override
    public int checkDronePercentage(long drone) {
        throw new IllegalStateException("Operation not implemented");
    }
}
