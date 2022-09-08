package com.musalasoft.droneservice.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

/**
 * @author Alex Maina
 * @created 08/09/2022
 **/
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class UniversalResponse {
    private int status;
    private String message;
    private Object data;
}
