package com.musalasoft.droneservice.repository;

import com.musalasoft.droneservice.model.DeliveryLoad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DeliveryLoadRepository extends JpaRepository<DeliveryLoad,Long> {

    Optional<DeliveryLoad> findDeliveryLoadByDeliveryIdAndMedicineIdAndSoftDeleteFalse(long deliveryId,long medicineId);
    @Query(value = "select DeliveryLoad from DeliveryLoad dl " +
            "inner join Delivery d on d.id= dl.delivery.id" +
            " inner join Drone dr  on d.drone.id=dr.id" +
            " where d.deliveryStatus='LOADING' or d.deliveryStatus='DELIVERING' and dr.id=?1")
    List<DeliveryLoad> checkLoadedMedicationOnDrone(long droneId);
}
