package com.musalasoft.droneservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.musalasoft.droneservice.common.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Alex Maina
 * @created 08/09/2022
 **/
@Entity
@Table(name="tb_medicine")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Medicine extends BaseEntity {
    private String name;
    private String weight;
    private String code;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String imageUrl;
    private String image;
}
