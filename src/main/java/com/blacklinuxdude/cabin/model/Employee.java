package com.blacklinuxdude.cabin.model;

import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Created by kdeleon on 9/10/14.
 */
public class Employee {

    @Id
    private String id;

    private String name;

    private Date hired;

    private Integer seniorityOverride;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getHired() {
        return hired;
    }

    public void setHired(Date hired) {
        this.hired = hired;
    }

    public Integer getSeniorityOverride() {
        return seniorityOverride;
    }

    public void setSeniorityOverride(Integer seniorityOverride) {
        this.seniorityOverride = seniorityOverride;
    }
}
