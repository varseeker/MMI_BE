package com.enigma.betestmmi.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "mst_employee")
public class Employee {
    @Id
    @GeneratedValue(generator = "sequence_position_id", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequence_position_id", sequenceName = "sq_position_id", allocationSize = 1)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "birth_date",nullable = false)
    private Date birthDate;

    @ManyToOne
    @JoinColumn(name = "position_id", nullable = false)
    private Position positionId;

    @Column(name = "id_number",nullable = false)
    private Integer idNumber;
    private Integer gender;
    @Column(name = "is_delete",nullable = false)
    private Integer isDelete;

    public Employee() {
    }

    public Employee(String name, Date birthDate, Position positionId, Integer idNumber, Integer gender, Integer isDelete) {
        this.name = name;
        this.birthDate = birthDate;
        this.positionId = positionId;
        this.idNumber = idNumber;
        this.gender = gender;
        this.isDelete = isDelete;
    }

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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Position getPositionId() {
        return positionId;
    }

    public void setPositionId(Position positionId) {
        this.positionId = positionId;
    }

    public Integer getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Integer idNumber) {
        this.idNumber = idNumber;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
