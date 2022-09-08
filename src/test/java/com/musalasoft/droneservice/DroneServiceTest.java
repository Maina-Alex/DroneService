package com.musalasoft.droneservice;

import com.musalasoft.droneservice.constants.DroneState;
import com.musalasoft.droneservice.model.Delivery;
import com.musalasoft.droneservice.model.Drone;
import com.musalasoft.droneservice.model.MedicineLoad;
import com.musalasoft.droneservice.repository.DeliveryRepository;
import com.musalasoft.droneservice.repository.DroneRepository;
import com.musalasoft.droneservice.repository.MedicineLoadRepository;
import com.musalasoft.droneservice.service.DroneService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * @author Alex Maina
 * @created 08/09/2022
 **/
@SpringBootTest
class DroneServiceTest {
    @Autowired
    private DroneService droneService;
    @MockBean
    private DroneRepository droneRepository;
    @MockBean
    private DeliveryRepository deliveryRepository;


    private Drone drone;

    @BeforeEach
    public void setupDrone(){
        drone= Drone.builder ()
                .batteryPercentage (70)
                .state (DroneState.IDLE)
                .serialNo ("4622822472847")
                .weighLimit (400)
                .build ();
    }

    @Test
    @DisplayName ("Junit test to register drone")
    void registerDroneTest(){
        when (droneRepository.save (any (Drone.class))).thenReturn (drone);
        Drone savedDrone=droneService.registerDrone (drone);
        assertThat(savedDrone).isInstanceOf (Drone.class);
        assertThat (savedDrone.getId ()).isNotZero ();
    }

    @Test
    @DisplayName ("Junit test to load drone ")
    void loadDroneTest(){
        when (droneRepository.findById (any (Long.class))).thenReturn (Optional.of (drone));
        when (deliveryRepository.save (any (Delivery.class))).thenReturn (mock (Delivery.class));
        boolean loaded=droneService.loadDrone (any (Long.class),anyList ());
        assertThat (loaded).isTrue ();
    }

    @Test
    @DisplayName (("Junit test to test for loaded medication"))
    void checkLoadedMedicationTest(){
        Delivery delivery=mock (Delivery.class);
        when(deliveryRepository.findDeliveryByDroneIdAndCompletedFalseAndSoftDeleteFalse (Mockito.any (Long.class))).thenReturn (Optional.of (delivery));
        List<MedicineLoad> medicineLoads=droneService.checkLoadedMedication (Mockito.anyLong ());
        assertThat (medicineLoads).isNotNull ();
        assertThat (medicineLoads).isInstanceOf (List.class);

    }

    @Test
    @DisplayName ("Junit test to test for get available drone")
    void checkAvailableDroneTest(){
        Pageable pageable= PageRequest.of (0,5);
        List<Drone> droneList= List.of (drone);
        when (droneRepository.findAllByState (DroneState.IDLE,pageable)).thenReturn (droneList);
        assertThat (droneService.checkAvailableDrone (pageable)).isEqualTo (droneList);
    }

    @Test
    @DisplayName ("Junit test to test for check Drone Percentage")
    void checkDronePercentage(){
        when (droneRepository.findById (anyLong ())).thenReturn (Optional.of (drone));
        assertThat (droneService.checkDronePercentage (anyLong ())).isEqualTo (drone.getBatteryPercentage ());
    }



}
