package ru.nsu.ccfit.rivanov.hotel.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    private Place place;

    @ManyToOne
    private Visitor visitor;

    @ManyToOne
    private PartnerOrder partnerOrder;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    private List<AdditionalPayment> additionalPayments;

    @Column(name = "payed")
    private boolean payed;

    @Column(name = "booking_time")
    private Timestamp bookingTime;

    @Column(name = "arrival_time")
    private Timestamp arrivalTime;

    @Column(name = "discharge_time")
    private Timestamp dischargeTime;

    public List<AdditionalPayment> getAdditionalPayments() {
        return additionalPayments;
    }

    public void setAdditionalPayments(List<AdditionalPayment> additionalPayments) {
        this.additionalPayments = additionalPayments;
    }

    public Booking() {

    }

    public Booking(Place place, Visitor visitor, PartnerOrder partnerOrder, List<AdditionalPayment> additionalPayments, boolean payed, Timestamp bookingTime, Timestamp arrivalTime, Timestamp dischargeTime) {
        this.place = place;
        this.visitor = visitor;
        this.partnerOrder = partnerOrder;
        this.additionalPayments = additionalPayments;
        this.payed = payed;
        this.bookingTime = bookingTime;
        this.arrivalTime = arrivalTime;
        this.dischargeTime = dischargeTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public PartnerOrder getPartnerOrder() {
        return partnerOrder;
    }

    public void setPartnerOrder(PartnerOrder partnerOrder) {
        this.partnerOrder = partnerOrder;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    public Timestamp getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Timestamp bookingTime) {
        this.bookingTime = bookingTime;
    }

    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Timestamp arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Timestamp getDischargeTime() {
        return dischargeTime;
    }

    public void setDischargeTime(Timestamp dischargeTime) {
        this.dischargeTime = dischargeTime;
    }
}
