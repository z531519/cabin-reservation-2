package com.blacklinuxdude.cabin.resource

import com.blacklinuxdude.cabin.model.Employee
import com.blacklinuxdude.cabin.model.Reservation
import com.blacklinuxdude.cabin.model.ReservationBid
import com.blacklinuxdude.cabin.repository.EmployeeRepository
import com.blacklinuxdude.cabin.repository.ReservationBidRepository
import com.blacklinuxdude.cabin.repository.ReservationRepository
import com.blacklinuxdude.cabin.repository.SeasonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController


/**
 * Created by kdeleon on 10/2/14.
 */
@RestController
@RequestMapping("/employees")
class EmployeeResourceController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    ReservationBidRepository reservationBidRepository;

    @Autowired
    SeasonRepository seasonRepository;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> getEmployees() {
        return employeeRepository.findAll()
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Employee updateEmployee(@PathVariable('id') String id, @RequestBody Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }


    @ResponseBody
    @RequestMapping(value = "/{id}/reservations", method = RequestMethod.GET)
    public Iterable<Reservation> getEmployeeReservations(@PathVariable('id') String id) {
        def employee = employeeRepository.findOne(id)
        return reservationRepository.findByEmployee(employee)
    }

    @ResponseBody
    @RequestMapping(value = "/{id}/bids", method = RequestMethod.GET)
    public List<ReservationBid> getEmployeeReservationBids(@PathVariable('id') String id) {

        return reservationBidRepository.findByEmployeeAndSeason(
                employeeRepository.findOne(id),
                seasonRepository.findByOpenSeason(true)
        )
    }


    @ResponseBody
    @RequestMapping(value = "/{id}/bids", method = RequestMethod.POST)
    public ReservationBid saveEmployeeBid(@PathVariable('id') String id, @RequestBody ReservationBid reservationBid) {
        reservationBid.setSeason(seasonRepository.findByOpenSeason(true));
        reservationBid = reservationRepository.save(reservationBid)
        return reservationBid;
    }



}
