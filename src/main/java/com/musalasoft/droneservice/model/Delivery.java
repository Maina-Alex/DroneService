package com.musalasoft.droneservice.model;

import com.musalasoft.droneservice.common.BaseEntity;
import com.musalasoft.droneservice.constants.DeliveryStatus;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Alex Maina
 * @created 08/09/2022
 **/
@Entity
@Table(name="tb_delivery")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Delivery extends BaseEntity {
    @ManyToOne
    private Drone drone;
    @OneToMany(fetch = FetchType.LAZY)
    private Set<DeliveryLoad> medicines;
    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;
    private double loadWeight=0;
}
