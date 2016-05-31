package ru.nsu.ccfit.rivanov.hotel.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ccfit.rivanov.hotel.entities.Visitor;

public interface VisitorRepository extends JpaRepository<Visitor, Long> {
}
