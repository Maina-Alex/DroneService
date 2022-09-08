package com.musalasoft.droneservice.model;

import com.musalasoft.droneservice.common.BaseEntity;
import com.musalasoft.droneservice.constants.DroneState;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 * @author Alex Maina
 * @created 08/09/2022
 **/
@Entity
@Table(name="tb_drone")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Drone  extends BaseEntity {
    private String serialNo;
    private String model;
    private double weighLimit;
    private int batteryPercentage;
    @Enumerated(EnumType.STRING)
    private DroneState state;
}
