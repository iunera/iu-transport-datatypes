package com.iunera.publictransport.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class GtfsTripDetailsData {

  public String tripId;
  public String departureStopName;
  public String arrivalStopName;
  public String zoneId; // timeZone

  public String direction;
  public String routeId;
  public String routeShortName;
  public String routeLongName;
  public String departureStopId;
  public String arrivalStopId;

  // the validity operation date of timetable scheduled
  public LocalDate date;
  public LocalTime plannedDepartureTime;
  public LocalTime plannedArrivalTime;

  public LocalDateTime plannedDepartureDateTime; // date+plannedDepartureTime
  public LocalDateTime plannedArrivalDateTime; // when larger then 24 hours then add ene day to the
                                               // operation date

  public String stopLatitude;
  public String stopLongitude;

}
