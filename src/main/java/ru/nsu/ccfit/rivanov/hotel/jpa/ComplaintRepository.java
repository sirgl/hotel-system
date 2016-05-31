package ru.nsu.ccfit.rivanov.hotel.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ccfit.rivanov.hotel.entities.Complaint;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
}
