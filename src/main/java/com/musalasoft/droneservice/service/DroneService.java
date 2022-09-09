package com.musalasoft.droneservice.service;

import com.musalasoft.droneservice.model.Delivery;
import com.musalasoft.droneservice.model.Drone;
import com.musalasoft.droneservice.model.DeliveryLoad;
import com.musalasoft.droneservice.model.Medicine;
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
     * @param droneId  Drone Id
     * @param medicine medicine load to pack into drone
     * @return success (true) or failed (false)
     */
    Delivery loadDrone(long droneId, Medicine medicine);
    /**
     *
     * @param drone drone id to for loaded medicines
     * @return a list of medicines with loaded quantities
     */

    List<DeliveryLoad> checkLoadedMedication(long drone);

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
