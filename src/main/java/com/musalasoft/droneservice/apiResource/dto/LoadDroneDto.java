package com.musalasoft.droneservice.apiResource.dto;

import lombok.Data;

/**
 * @author Alex Maina
 * @created 09/09/2022
 **/
@Data
public class LoadDroneDto {
    private final long droneId;
    private final long medicineId;
}
