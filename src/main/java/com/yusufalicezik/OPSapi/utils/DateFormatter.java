package com.yusufalicezik.OPSapi.utils;

import org.joda.time.DateTime;
import org.joda.time.Period;

import java.util.Date;

public class DateFormatter {
    public int getTotalAmountFromDate(Date enterDate, Date exitDate, int amountPerHour){
        Period p = new Period(new DateTime(enterDate), new DateTime(exitDate));
        if (p.getMinutes() <= 15){
            return 0;
        }else{
            return amountPerHour*p.getHours();
        }
    }
}
