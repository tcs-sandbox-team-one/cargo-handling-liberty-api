package com.cargotracker.handling.infrastructure.repositories;

import com.cargotracker.handling.domain.model.aggregates.HandlingActivity;
import com.cargotracker.handling.domain.model.valueobjects.CargoBookingId;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository class for the Cargo Aggregate
 */
public interface HandlingActivityRepository extends JpaRepository<HandlingActivity, Long> {
    HandlingActivity findByBookingId(CargoBookingId cargoBookingId);
}