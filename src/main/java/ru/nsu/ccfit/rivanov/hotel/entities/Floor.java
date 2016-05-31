package ru.nsu.ccfit.rivanov.hotel.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "floors")
public class Floor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "number")
    private long number;

    @ManyToOne
    private Corpus corpus;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "floor")
    private List<Room> rooms;

    public Floor() {
    }

    public Floor(long number, Corpus corpus, List<Room> rooms) {
        this.number = number;
        this.corpus = corpus;
        this.rooms = rooms;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Corpus getCorpus() {
        return corpus;
    }

    public void setCorpus(Corpus corpus) {
        this.corpus = corpus;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }
}
