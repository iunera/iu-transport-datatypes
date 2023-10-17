package com.iunera.publictransport.domain;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class PlannedDeparture implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 7430274048599908150L;

  public PlannedDeparture() {


  }

  public PlannedDeparture(LocalTime deparatureTime, String direction, String line_id,
      String lineLabel) {
    this.deparatureTime = deparatureTime;
    this.direction = direction;
    this.line_id = line_id;
    this.line_label = lineLabel;

  }

  public LocalTime deparatureTime;
  public String direction;
  public String line_id;
  public String line_label;

  public List<LocalDate> additionalDepatureDates;
  public List<LocalDate> excludedDepatureDates;

  public List<DayOfWeek> depatureWeekdays;
  public List<LocalDate> depatureWeekdaysValidFrom;
  public List<LocalDate> depatureWeekdaysValidTo;

}
