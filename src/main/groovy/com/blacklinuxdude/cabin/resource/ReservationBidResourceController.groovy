package com.blacklinuxdude.cabin.resource

import com.blacklinuxdude.cabin.model.Employee
import com.blacklinuxdude.cabin.model.Reservation
import com.blacklinuxdude.cabin.model.ReservationBid
import com.blacklinuxdude.cabin.repository.EmployeeRepository
import com.blacklinuxdude.cabin.repository.ReservationBidRepository
import com.blacklinuxdude.cabin.repository.ReservationRepository
import com.blacklinuxdude.cabin.repository.SeasonRepository
import com.blacklinuxdude.cabin.resource.command.ReservationBidOrderCommand
import com.blacklinuxdude.cabin.service.BiddingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.propertyeditors.CustomDateEditor
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.*

import java.text.SimpleDateFormat

/**
 * Created by kdeleon on 10/2/14.
 */
@RestController
@RequestMapping("/bids")
class ReservationBidResourceController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    ReservationBidRepository reservationBidRepository;

    @Autowired
    SeasonRepository seasonRepository;

    @Autowired
    BiddingService biddingService;


    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public ReservationBid updateEmployee(@PathVariable('id') Long id, @RequestBody ReservationBid bid) {
        reservationBidRepository.save(bid)
        return bid
    }



}
