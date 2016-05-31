package ru.nsu.ccfit.rivanov.hotel.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "partner_orders")
public class PartnerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    private PartnerCompany partnerCompany;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "partnerOrder")
    private List<Booking> bookings;

    public PartnerOrder() {
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public PartnerOrder(PartnerCompany partnerCompany, List<Booking> bookings) {
        this.partnerCompany = partnerCompany;
        this.bookings = bookings;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PartnerCompany getPartnerCompany() {
        return partnerCompany;
    }

    public void setPartnerCompany(PartnerCompany partnerCompany) {
        this.partnerCompany = partnerCompany;
    }
}
