package com.musalasoft.droneservice.model;

import com.musalasoft.droneservice.common.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
public class DeliveryLoad extends BaseEntity {
    @ManyToOne
    private Medicine medicine;
    private int count;
    @ManyToOne
    private  Delivery delivery;

}
