/*	$ Header: $
 *
 *	Copyright 2014 NCS Pearson, Inc. All rights reserved.
 */

package com.blacklinuxdude.cabin.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * @author vdeleke
 * @version $Revision: #1 $ submitted $DateTime: 2013/08/29 10:34:55 $ by $Author: clemka $
 * @since 2.3.xxxx
 */
@Entity
public class Season {
    @Id
    private String id;

    enum Phase { SUMMER, WINTER};

    int year;

    boolean openSeason = false;

    @ManyToMany
    private List<Asset> assets;

    private Phase phase;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }

    public Phase getPhase() {
        return phase;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
    }

    public boolean isOpenSeason() {
        return openSeason;
    }

    public void setOpenSeason(boolean openSeason) {
        this.openSeason = openSeason;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
