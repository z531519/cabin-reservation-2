/*	$ Header: $
 *
 *	Copyright 2014 NCS Pearson, Inc. All rights reserved.
 */

package com.blacklinuxdude.cabin.model;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;

import javax.persistence.*;
import java.util.Date;

/**
 * @author vdeleke
 * @version $Revision: #1 $ submitted $DateTime: 2013/08/29 10:34:55 $ by $Author: clemka $
 * @since 2.3.xxxx
 */
@Entity
public class ReservationBid {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private Asset asset;

    @ManyToOne
    private Season season;

    @Column(nullable = false)
    private int priority;
    @Column(nullable = false)
    private Date checkinDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Date getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }
}
