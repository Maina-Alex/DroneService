package com.musalasoft.droneservice.service;

import com.musalasoft.droneservice.model.Drone;
import com.musalasoft.droneservice.model.MedicineLoad;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DroneService {
    /**
     *
     * @param drone  object to register
     * @return  return newly registered drone
     */

    Drone registerDrone(Drone drone);
    /**
     *
     * @param droneId Drone Id
     * @param medicineLoad medicine load to pack into drone
     * @return success (true) or failed (false)
     */

    boolean loadDrone(long droneId, List<MedicineLoad> medicineLoad);
    /**
     *
     * @param drone drone id to for loaded medicines
     * @return a list of medicines with loaded quantities
     */

    List<MedicineLoad> checkLoadedMedication(long drone);
    /**
     *
     * @param pageable get results as pages
     * @return a list of available drones
     */
    List<Drone> checkAvailableDrone(Pageable pageable);

    /**
     *
     * @param drone drone Id
     * @return percentage of drone
     */
    int checkDronePercentage(long drone);


}
