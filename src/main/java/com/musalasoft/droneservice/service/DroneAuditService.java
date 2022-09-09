package com.musalasoft.droneservice.service;

import com.musalasoft.droneservice.model.DroneAudit;

import java.util.Date;
import java.util.List;

public interface DroneAuditService {
    void checkDronePercentages();
    List<DroneAudit> getDroneAuditByTimeRange(long droneId, Date startDate, Date endDate);
}