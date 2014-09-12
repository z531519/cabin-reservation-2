/*	$ Header: $
 *
 *	Copyright 2014 NCS Pearson, Inc. All rights reserved.
 */

package com.blacklinuxdude.cabin.model;

import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

/**
 * @author vdeleke
 * @version $Revision: #1 $ submitted $DateTime: 2013/08/29 10:34:55 $ by $Author: clemka $
 * @since 2.3.xxxx
 */
public class Season {
    @Id
    private String id;

    enum Phase { SUMMER, WINTER};

    @ManyToMany
    private List<Asset> assets;

    private Phase season;

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

    public Phase getSeason() {
        return season;
    }

    public void setSeason(Phase season) {
        this.season = season;
    }
}
