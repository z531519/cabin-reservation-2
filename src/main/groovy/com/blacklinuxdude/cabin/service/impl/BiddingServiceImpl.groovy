package com.blacklinuxdude.cabin.service.impl

import com.blacklinuxdude.cabin.model.Asset
import com.blacklinuxdude.cabin.model.Employee
import com.blacklinuxdude.cabin.model.ReservationBid
import com.blacklinuxdude.cabin.model.Season
import com.blacklinuxdude.cabin.repository.AssetRepository
import com.blacklinuxdude.cabin.repository.EmployeeRepository
import com.blacklinuxdude.cabin.repository.ReservationBidRepository
import com.blacklinuxdude.cabin.repository.SeasonRepository
import com.blacklinuxdude.cabin.service.BiddingService
import com.blacklinuxdude.cabin.service.VacationDateHelper
import org.apache.log4j.Logger
import org.joda.time.DateTime
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Created by kdeleon on 10/6/14.
 */
@Service
@Transactional
class BiddingServiceImpl implements BiddingService {
    public static final Logger LOG = Logger.getLogger(BiddingServiceImpl.class)

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ReservationBidRepository reservationBidRepository;

    @Autowired
    AssetRepository assetRepository;

    @Autowired
    SeasonRepository seasonRepository;

    @Override
    public ReservationBid createBid(Employee employee, Asset asset, Date targetDate) {
        ReservationBid bid = new ReservationBid(employee: employee, asset: asset,
                season: seasonRepository.findByOpenSeason(true))
        Date checkinDate = VacationDateHelper.getFrom(new DateTime(targetDate)).toDate()

        bid.checkinDate = checkinDate

        try {
            bid = reservationBidRepository.save(bid)
        } catch(DataIntegrityViolationException e) {
            LOG.warn('Constraint issue', e)
            return null;
        }
        return bid
    }

    @Override
    public void reorderBids(List<ReservationBid> orderedBids) {
        int priority = 0;
        for (ReservationBid bid : orderedBids) {
            bid.priority = priority++
            reservationBidRepository.save(bid)
        }
    }

    @Override
    void evaluateBids() {
        List<Employee> orderedEmployees = employeeRepository.findByOrderByHiredAsc()
        Season season = seasonRepository.findByOpenSeason(true)
        for (Employee employee: orderedEmployees) {
            List<ReservationBid> bids = reservationBidRepository.findByEmployeeAndSeasonOrderByPriorityAsc(employee, season)
            boolean hasWon = false
            for (ReservationBid bid : bids) {
                if (bid.won) {
                    hasWon = true
                    LOG.info('Employee ${employee.name} has won already, skipped')
                    break
                }
            }
            if (!hasWon) {
                for (ReservationBid bid : bids) {
                    ReservationBid won = reservationBidRepository
                            .findByAssetAndSeasonAndCheckinDateAndWon(bid.asset, season, bid.checkinDate, true)
                    if (!won) {
                        bid.won = true
                        reservationBidRepository.save(bid)
                        break;
                    }
                }
            }
        }
    }
}
