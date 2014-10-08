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
    String className
    def data

    public static FullCalendar create(Reservation reservation) {
        Date date = reservation.date
        DateTime dateTime = new DateTime(date)
        DateTimeFormatter fmt = DateTimeFormat.forPattern('yyyy-MM-dd')
        def start = fmt.print(VacationDateHelper.getFrom(dateTime))
        def end = fmt.print(VacationDateHelper.getTo(dateTime))
        new FullCalendar(id : reservation.id, title: reservation.employee.name + ' : ' + reservation.asset.name,
                allDay: true,
                className: reservation.asset.id,
                start:start, end:end,
                data: reservation)
    }

    public static FullCalendar create(ReservationBid reservation) {
        Date date = reservation.checkinDate
        DateTime dateTime = new DateTime(date)
        DateTimeFormatter fmt = DateTimeFormat.forPattern('yyyy-MM-dd')
        def start = fmt.print(VacationDateHelper.getFrom(dateTime))
        def end = fmt.print(VacationDateHelper.getTo(dateTime))

        new FullCalendar(id : reservation.id, title: reservation.employee.name + ' : ' + reservation.asset.name,
                allDay: true,
                className: reservation.asset.id + ' ' + (reservation.won ? 'bid-won':'bid'),
                start:start, end:end,
                data: reservation)
    }
}
