package com.musalasoft.droneservice.model;

import com.musalasoft.droneservice.common.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

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
    @OneToMany
    private List<MedicineLoad> medicines;
    private boolean completed;
    private double loadWeight;
}
