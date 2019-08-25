package com.mz.phoneBook.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "City")
public class City extends BaseEntity<Integer>{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "City_Id" , nullable = false)
    private Integer id;

    @Column(name = "City", nullable = false)
    private String name;

    @ManyToOne(targetEntity = State.class)
    @JoinColumn(name = "State_Id" , nullable = false)
    private State state;

    @Column(name = "Last_Update" , nullable = false)
    private Date lUpdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Date getlUpdate() {
        return lUpdate;
    }

    public void setlUpdate(Date lUpdate) {
        this.lUpdate = lUpdate;
    }
}
