package ru.nsu.ccfit.rivanov.hotel.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "partner_companies")
public class PartnerCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "registration_date")
    private Date registrationDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "partnerCompany")
    private List<PartnerOrder> orders;

    public PartnerCompany() {
    }

    public List<PartnerOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<PartnerOrder> orders) {
        this.orders = orders;
    }

    public PartnerCompany(String name, Date registrationDate, List<PartnerOrder> orders) {
        this.name = name;
        this.registrationDate = registrationDate;
        this.orders = orders;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
