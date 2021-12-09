package com.enigma.betestmmi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mst_position")
public class Position {
    @Id
    @GeneratedValue(generator = "sequence_position_id", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequence_position_id", sequenceName = "sq_position_id", allocationSize = 1)
    private Integer id;

    @Column(length = 50)
    private String code;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "is_delete")
    private Integer isDelete;

    @OneToMany(mappedBy = "positionId", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Employee> employees = new ArrayList<>();

    public Position() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @JsonIgnore
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
