package com.vytrack.utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {


    public static   String localDateNow(){
        LocalDateTime localDateTime = LocalDateTime.now();
       return localDateTime.format(DateTimeFormatter.ofPattern("MMM d, yyyy"));
    }

    public static  String localTimeNow(){
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.format(DateTimeFormatter.ofPattern("h:mm a"));
    }

    public static String localTimePlus(long hours, long minutes){
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime=localDateTime.plusHours(hours);
        localDateTime=localDateTime.plusMinutes(minutes);
        return localDateTime.format(DateTimeFormatter.ofPattern("h:mm a"));
    }

    public static   String localTimeMinus(long hours, long minutes){
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime=localDateTime.minusHours(hours);
        localDateTime=localDateTime.minusMinutes(minutes);
        return localDateTime.format(DateTimeFormatter.ofPattern("h:mm a"));
    }

    public static   String localDatePlus(long days){
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime=localDateTime.plusDays(days);
        return localDateTime.format(DateTimeFormatter.ofPattern("MMM d, yyyy"));
    }

    public static   String localDateMinus(long days){
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime=localDateTime.minusDays(days);
        return localDateTime.format(DateTimeFormatter.ofPattern("MMM d, yyyy"));
    }


}
