package com.musalasoft.droneservice.repository;

import com.musalasoft.droneservice.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine,Long> {
}
