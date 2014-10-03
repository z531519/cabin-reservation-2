package com.blacklinuxdude.cabin.resource

import com.blacklinuxdude.cabin.controller.data.FullCalendar
import com.blacklinuxdude.cabin.model.Employee
import com.blacklinuxdude.cabin.model.Reservation
import com.blacklinuxdude.cabin.repository.EmployeeRepository
import com.blacklinuxdude.cabin.repository.ReservationRepository
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * Created by kdeleon on 10/2/14.
 */
@RestController
@RequestMapping("/reservations")
class ReservationResourceController {

    @Autowired
    ReservationRepository reservationRepository;


    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Reservation> getReservationByMonth(
            @RequestParam("month") int month, @RequestParam("year") int year) {

        DateTime from = new DateTime(year, month, 1, 0, 0);
        DateTime to = new DateTime(year, month, 31, 23, 59);

        return reservationRepository.findByDateBetween(from.toDate(), to.toDate())
    }

    @ResponseBody
    @RequestMapping(value="/fullcalendar", method = RequestMethod.GET)
    public Iterable<FullCalendar> getFullCalendarByMonth(
            @RequestParam("start") String start, @RequestParam("end") String end) {
        DateTimeFormatter fmt = DateTimeFormat.forPattern('yyyy-MM-dd')

        DateTime from = fmt.parseDateTime(start)
        DateTime to = fmt.parseDateTime(end)

        def reservations = reservationRepository.findByDateBetween(from.toDate(), to.toDate())
        return reservations.collect { Reservation r ->
            FullCalendar.create(r)
        }
    }


}
