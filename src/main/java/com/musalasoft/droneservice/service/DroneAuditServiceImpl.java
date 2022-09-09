package com.musalasoft.droneservice.service;

import com.musalasoft.droneservice.constants.DroneState;
import com.musalasoft.droneservice.model.DroneAudit;
import com.musalasoft.droneservice.repository.DroneAuditRepository;
import com.musalasoft.droneservice.repository.DroneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * @author Alex Maina
 * @created 09/09/2022
 **/
@Service
@RequiredArgsConstructor
public class DroneAuditServiceImpl implements  DroneAuditService {
    private final DroneAuditRepository droneAuditRepository;
    private final DroneCommunicationService droneCommunicationService;
    private final DroneRepository droneRepository;

    private final Executor executor;

    @Scheduled(fixedDelay = 5000)
    @Override
    public void checkDronePercentages() {
        Mono.fromRunnable (()-> droneRepository.findAllBySoftDeleteFalse ()
                .parallelStream ()
                .forEach (drone -> {
                   int batteryPerc= droneCommunicationService.getDronePercentage (drone);
                    DroneState droneState= droneCommunicationService.getDroneState (drone);
                   drone.setBatteryPercentage (batteryPerc);
                   drone.setState (droneState);
                   droneRepository.save (drone);
                   DroneAudit audit= DroneAudit.builder()
                           .drone (drone)
                           .batteryPercentage (batteryPerc)
                           .build();
                   audit.setDroneState (droneState);
                   droneAuditRepository.save (audit);
                })).subscribeOn (Schedulers.fromExecutor (executor)).subscribe ();
    }

    @Override
    public List<DroneAudit> getDroneAuditByTimeRange(long droneId, Date startDate, Date endDate) {
        return droneAuditRepository.findAllByDroneIdAndCreatedOnBetween (droneId,startDate,endDate);
    }
}
