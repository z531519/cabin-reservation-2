package com.blacklinuxdude.cabin.service;

import com.blacklinuxdude.cabin.model.Asset;
import com.blacklinuxdude.cabin.model.Employee;
import com.blacklinuxdude.cabin.model.ReservationBid;

import java.util.Date;

/**
 * Created by kdeleon on 10/6/14.
 */
public interface BiddingService {
    public void reorderBids(java.util.List<ReservationBid> orderedBids);

    public ReservationBid createBid(Employee employee, Asset asset, Date targetDate);

    public void evaluateBids();
}
