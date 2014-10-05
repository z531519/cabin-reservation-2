package com.blacklinuxdude.cabin.resource

import com.blacklinuxdude.cabin.controller.data.FullCalendar
import com.blacklinuxdude.cabin.model.Reservation
import com.blacklinuxdude.cabin.model.ReservationBid
import com.blacklinuxdude.cabin.model.Season
import com.blacklinuxdude.cabin.repository.ReservationBidRepository
import com.blacklinuxdude.cabin.repository.ReservationRepository
import com.blacklinuxdude.cabin.repository.SeasonRepository
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * Created by kdeleon on 10/2/14.
 */
@RestController
@RequestMapping("/seasons")
class SeasonResourceController {

    @Autowired
    SeasonRepository seasonRepository;

    @Autowired
    ReservationBidRepository reservationBidRepository;


    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public List<Season> getAllSeasons() {

        return seasonRepository.findAll();
    }

    @ResponseBody
    @RequestMapping(value="/open", method = RequestMethod.GET)
    public Season getOpenSeason() {

        return seasonRepository.findByOpenSeason(true);
    }

    @ResponseBody
    @RequestMapping(value="/{seasonId}/bids", method = RequestMethod.GET)
    public List<ReservationBid> getReservationBids(@PathVariable('seasonId') String seasonId) {

        return reservationBidRepository.findBySeason(seasonRepository.findOne(seasonId))
    }





}
