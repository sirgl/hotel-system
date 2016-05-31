package ru.nsu.ccfit.rivanov.hotel.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "additional_services")
public class AdditionalService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "additionalServices")
    private List<Corpus> corpuses;

    public AdditionalService() {
    }

    public AdditionalService(String name) {
        this.name = name;
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
}
