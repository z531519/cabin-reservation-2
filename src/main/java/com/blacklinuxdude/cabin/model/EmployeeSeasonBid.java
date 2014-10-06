/*	$ Header: $
 *
 *	Copyright 2014 NCS Pearson, Inc. All rights reserved.
 */

package com.blacklinuxdude.cabin.model;

import javax.persistence.*;
import java.util.List;

/**
 * @author VDELEKE
 * @version $Revision: #1 $ submitted $DateTime: 2013/08/29 10:34:55 $ by $Author: clemka $
 */
@Entity
public class EmployeeSeasonBid {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private Season season;

    @OneToMany
    @OrderColumn(name="INDEX")
    private List<ReservationBid> bids;


}
