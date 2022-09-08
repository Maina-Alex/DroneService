package com.musalasoft.droneservice.model;

import com.musalasoft.droneservice.common.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;
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
    private Set<MedicineLoad> medicines;
    private boolean completed;
    private double loadWeight;
}
