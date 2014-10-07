package com.blacklinuxdude.cabin.controller.data

import com.blacklinuxdude.cabin.model.Reservation
import com.blacklinuxdude.cabin.model.ReservationBid
import com.blacklinuxdude.cabin.service.VacationDateHelper
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter

/**
 *
 * @author VDELEKE
 * @version $Revision: #1 $ submitted $DateTime: 2013/08/29 10:34:55 $ by $Author: clemka $
 */
class FullCalendar {
    String id
    String title
    boolean allDay
    String start
    String end
    String url

    public static FullCalendar create(Reservation reservation) {
        Date date = reservation.date
        DateTime dateTime = new DateTime(date)
        DateTimeFormatter fmt = DateTimeFormat.forPattern('yyyy-MM-dd')
        def start = fmt.print(VacationDateHelper.getFrom(dateTime))
        def end = fmt.print(VacationDateHelper.getTo(dateTime))
        new FullCalendar(id : reservation.id, title: reservation.employee.name, allDay: true,
            start:start, end:end)
    }

    public static FullCalendar create(ReservationBid reservation) {
        Date date = reservation.checkinDate
        DateTime dateTime = new DateTime(date)
        DateTimeFormatter fmt = DateTimeFormat.forPattern('yyyy-MM-dd')
        def start = fmt.print(VacationDateHelper.getFrom(dateTime))
        def end = fmt.print(VacationDateHelper.getTo(dateTime))
        new FullCalendar(id : reservation.id, title: reservation.employee.name, allDay: true,
                start:start, end:end)
    }
}
