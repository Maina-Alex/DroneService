package com.musalasoft.droneservice.repository;

import com.musalasoft.droneservice.model.DeliveryLoad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeliveryLoadRepository extends JpaRepository<DeliveryLoad,Long> {

    Optional<DeliveryLoad> findDeliveryLoadByDeliveryIdAndMedicineIdAndSoftDeleteFalse(long deliveryId,long medicineId);
}
