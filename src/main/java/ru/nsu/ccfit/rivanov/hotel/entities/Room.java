package ru.nsu.ccfit.rivanov.hotel.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "number")
    private long number;

    @ManyToOne
    private Floor floor;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "room")
    private List<Place> places;

    @Column(name = "cost")
    private BigDecimal cost;

    public Room() {
    }

    public Room(long number, Floor floor, List<Place> places, BigDecimal cost) {
        this.number = number;
        this.floor = floor;
        this.places = places;
        this.cost = cost;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }
}
