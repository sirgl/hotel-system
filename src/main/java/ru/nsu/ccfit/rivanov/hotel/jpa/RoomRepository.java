package ru.nsu.ccfit.rivanov.hotel.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ccfit.rivanov.hotel.entities.Room;

public interface RoomRepository  extends JpaRepository<Room, Long> {
}
