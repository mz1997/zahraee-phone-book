package com.mz.phoneBook.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PhoneBook")
public class PhoneBook extends BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PhoneBook_Id", nullable = false)
    private Integer id;

    @Column(name = "First_Name" , nullable = false)
    private String fName;

    @Column(name = "Last_Name" , nullable = false)
    private String lName;

    @Column(name = "Phone_Number" , nullable = false)
    private Long phone;

    @Column(name = "E_Mail")
    private String mail;

    @ManyToOne(targetEntity = Address.class)
    @JoinColumn(name = "Address_Id" , nullable = false)
    private Address address;

    @Column(name = "Last_Update" , nullable = false)
    private Date lUpdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getlUpdate() {
        return lUpdate;
    }

    public void setlUpdate(Date lUpdate) {
        this.lUpdate = lUpdate;
    }
}
