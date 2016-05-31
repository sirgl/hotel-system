package ru.nsu.ccfit.rivanov.hotel.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ccfit.rivanov.hotel.entities.AdditionalPayment;

public interface AdditionalPaymentRepository extends JpaRepository<AdditionalPayment, Long> {
}
