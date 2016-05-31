package ru.nsu.ccfit.rivanov.hotel.entities;

import javax.persistence.*;

@Entity
@Table(name = "additional_payments")
public class AdditionalPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "cost")
    private long cost;

    @ManyToOne
    private Booking booking;

    @ManyToOne
    private AdditionalService service;

    public AdditionalPayment(Booking booking, AdditionalService service) {
        this.booking = booking;
        this.service = service;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public AdditionalService getService() {
        return service;
    }

    public void setService(AdditionalService service) {
        this.service = service;
    }

    public AdditionalPayment() {

    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }
}
