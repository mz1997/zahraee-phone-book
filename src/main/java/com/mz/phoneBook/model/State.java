package com.mz.phoneBook.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "State")
public class State extends BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "State_Id" , nullable = false)
    private Integer id;

    @Column(name = "State", nullable = false)
    private String name;

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

    public Date getlUpdate() {
        return lUpdate;
    }

    public void setlUpdate(Date lUpdate) {
        this.lUpdate = lUpdate;
    }
}
