package ru.nsu.ccfit.rivanov.hotel.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.nsu.ccfit.rivanov.hotel.entities.Booking;
import ru.nsu.ccfit.rivanov.hotel.entities.Room;

import java.util.Date;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query("SELECT r FROM Room r WHERE r not in (SELECT r FROM Booking b JOIN b.place p JOIN p.room r " +
            "WHERE ((b.arrivalTime < ?1 and b.dischargeTime > ?1) or " +
            "(b.arrivalTime < ?2 and b.dischargeTime > ?2)))")
    List<Room> findEmptyRoomsByPeriod(Date start, Date endTime);
}
