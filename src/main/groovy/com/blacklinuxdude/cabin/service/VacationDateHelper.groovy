package com.blacklinuxdude.cabin.service

import org.joda.time.DateTime
import org.joda.time.DateTimeConstants

/**
 *
 * @author VDELEKE
 * @version $Revision: #1 $ submitted $DateTime: 2013/08/29 10:34:55 $ by $Author: clemka $
 */
class VacationDateHelper {

    static boolean isWeekendDate(DateTime date) {
        return date.getDayOfWeek() >= DateTimeConstants.FRIDAY &&  date.getDayOfWeek() <= DateTimeConstants.SUNDAY
    }

    static DateTime getFrom(DateTime date) {
        if (isWeekendDate(date)) {
            return date.withDayOfWeek(DateTimeConstants.FRIDAY).withHourOfDay(16)
        } else {
            return date.withDayOfWeek(DateTimeConstants.MONDAY)
        }
    }

    static DateTime getTo(DateTime date) {
        if (isWeekendDate(date)) {
            return getFrom(date).plusDays(3)
        } else {
            return getFrom(date).plusDays(5)
        }
    }
}
