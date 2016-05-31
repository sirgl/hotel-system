package ru.nsu.ccfit.rivanov.hotel.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "corpuses")
public class Corpus {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "corpus")
    private List<Floor> floors;

    @Column(name = "name")
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<AdditionalService> additionalServices;

    public Corpus() {
    }

    public Corpus(List<Floor> floors, String name, List<AdditionalService> additionalServices) {
        this.floors = floors;
        this.name = name;
        this.additionalServices = additionalServices;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    public List<AdditionalService> getAdditionalServices() {
        return additionalServices;
    }

    public void setAdditionalServices(List<AdditionalService> additionalServices) {
        this.additionalServices = additionalServices;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
