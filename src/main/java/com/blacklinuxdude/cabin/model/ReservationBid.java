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

//    @Column(nullable = false)
    @ManyToOne
    private Asset asset;

    @Column(nullable = false)
    private int priority;
    @Column(nullable = false)
    private Date checkinDate;

    public boolean isWeekend() {
        DateTime dateTime = new DateTime(checkinDate);
        return (DateTimeConstants.FRIDAY == dateTime.getDayOfWeek());
    }


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
}
