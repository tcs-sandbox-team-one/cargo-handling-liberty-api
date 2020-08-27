package com.cargotracker.handling.application.internal.commandservices;

import com.cargotracker.handling.domain.model.aggregates.HandlingActivity;
import com.cargotracker.handling.domain.model.commands.HandlingActivityRegistrationCommand;
import com.cargotracker.handling.domain.model.valueobjects.CargoBookingId;
import com.cargotracker.handling.domain.model.valueobjects.Location;
import com.cargotracker.handling.domain.model.valueobjects.Type;
import com.cargotracker.handling.domain.model.valueobjects.VoyageNumber;
import com.cargotracker.handling.infrastructure.repositories.HandlingActivityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HandlingActivityRegistrationCommandService {

	@Autowired
    private HandlingActivityRepository handlingActivityRepository;
	
    /**
     * Service Command method to register a new Handling Activity
     * @return BookingId of the CargoBookingId
     */
    public void registerHandlingActivityService(HandlingActivityRegistrationCommand handlingActivityRegistrationCommand){
    	//System.out.println("Handling Voyage Number is"+handlingActivityRegistrationCommand.getVoyageNumber());
        if(!handlingActivityRegistrationCommand.getVoyageNumber().equals("")) {
        	HandlingActivity handlingActivity = new HandlingActivity(
        			new CargoBookingId(handlingActivityRegistrationCommand.getBookingId()),
                    	handlingActivityRegistrationCommand.getCompletionTime(),
                        Type.valueOf(handlingActivityRegistrationCommand.getHandlingType()),
                        new Location(handlingActivityRegistrationCommand.getUnLocode()),
                        new VoyageNumber(handlingActivityRegistrationCommand.getVoyageNumber()));
            handlingActivityRepository.save(handlingActivity);
        } else{
            HandlingActivity handlingActivity = new HandlingActivity(
            		new CargoBookingId(handlingActivityRegistrationCommand.getBookingId()),
                        handlingActivityRegistrationCommand.getCompletionTime(),
                        Type.valueOf(handlingActivityRegistrationCommand.getHandlingType()),
                        new Location(handlingActivityRegistrationCommand.getUnLocode()));
            handlingActivityRepository.save(handlingActivity);
        }
    }
}
