package com.mz.phoneBook.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Address")
public class Address extends BaseEntity<Integer> {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Address_Id" , nullable = false)
    private Integer id;

    @Column(name = "Address", nullable = false)
    private String address;

    @Column(name = "Postal_Code", nullable = false)
    private Integer pCode;

    @ManyToOne(targetEntity = City.class)
    @JoinColumn(name = "City_Id" , nullable = false)
    private City city;

    @Column(name = "Last_Update" , nullable = false)
    private Date lUpdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getpCode() {
        return pCode;
    }

    public void setpCode(Integer pCode) {
        this.pCode = pCode;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Date getlUpdate() {
        return lUpdate;
    }

    public void setlUpdate(Date lUpdate) {
        this.lUpdate = lUpdate;
    }
}

