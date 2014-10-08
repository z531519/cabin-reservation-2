package com.blacklinuxdude.cabin.repository;

import com.blacklinuxdude.cabin.model.Asset;
import com.blacklinuxdude.cabin.model.Employee;
import com.blacklinuxdude.cabin.model.ReservationBid;
import com.blacklinuxdude.cabin.model.Season;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

//@RepositoryRestResource(collectionResourceRel = "bids", path = "bids")
@Repository
@Transactional
public interface ReservationBidRepository extends CrudRepository<ReservationBid, Long> {
    List<ReservationBid> findBySeason(Season p);

    List<ReservationBid> findBySeasonOrderByEmployeeHiredAsc(Season p);

    List<ReservationBid> findByEmployeeAndSeasonOrderByPriorityAsc(Employee employe, Season season);

    List<ReservationBid> findBySeasonAndCheckinDateBetween(Season season, Date from, Date to);

    List<ReservationBid> findBySeasonAndCheckinDateBetweenAndWon(Season season, Date from, Date to, boolean won);

    ReservationBid findByAssetAndSeasonAndCheckinDateAndWon(Asset asset, Season season, Date checkinDate, boolean won);
}
