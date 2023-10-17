package com.iunera.publictransport.domain;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * An object representing a waypoint like a stop in a ride with KPIs to be analyzed and ready to be
 * used for forecasts
 */
public class LineRideDetails {

  /** The unique ID of the record */
  public String eventId;



  // TODO new fields
  public String softwareVersion; // Basisversion_Nr
  public String route_circulationNo;
  public String route_courseId;
  // TODO: the unique id of the trip
  // -- trip id- that is the circulation number or so so the unique key for that - maybe daily ride
  // key plus the start time of the trip origin to generate it naturally

  public String route_journeyId;
  public String route; // Linienfahrweg_Nr
  public String stop_id;
  public String stopAbbreviation;
  public String stopPoint; // Haltepunkt_Nr
  public long currentOdometerValue; // Km_Stand


  // STOP
  public Double latitude;
  public Double longitude;
  public Double stop_planned_latitude;
  public Double stop_planned_longitude;

  public String[] stop_geoKeys;

  public String stop_label;
  /**
   * The planned platform where the vehicle was planned to stop - the real platform where it stopped
   * can be different
   */
  public String stop_plannedPlatform;
  /** The Platform where the vehicle stopped */
  public String stop_realPlatform;
  /** isSchoolOrUniversity, Mainstation */
  public String stop_function;
  public EStopType stop_type;


  /** Line - the unique id of the line unique even for different transport products */
  public String line_name;

  /**
   * The georegionkeys of the line - a line can have multiple geyokey as they can be expressed in
   * different precision levels
   */
  public String[] line_geoKeys;

  public String line_label;
  public TransportProductDTO line_transportProduct;
  public String line_direction;

  /** the bundle or network of lines - used */
  public String line_GroupId;
  public String line_Group;
  /** The administrative state where the line bundle operates */
  public String line_GroupState;


  public Line2 line;

  // time
  public Instant time_arrivalPlan;
  public Instant time_arrivalReal;
  public Instant time_departurePlan;
  public Instant time_departureReal;
  /**
   * The operation date. Sometimes schedules can leap over to the next day so we collect here one
   * day together
   */
  public LocalDate time_OperationDate;


  /**
   * The hour of the day for simplified queries. Can be used as query for hourly histograms, easily.
   * Zoned to the timezone of the departure
   */
  public Integer dayMeta_zonedHour;

  /**
   * The natural identifier for this recurring ride. Each ride at the same time on a different day
   * will have the same key when it is panned to stop within 100m at the same stop.
   */
  public String dayMeta_dailyRideStopKey;
  /**
   * Often rides get shifted for a few minutes and the dayMeta_dailyRideStopKey cannot be used for
   * other days. Therefore, we have here the keys which identify the nearest rides
   */
  public String[] dayMeta_dailyRideStopNearKeys;

  // weekday or weekend
  public EDayGroup dayMeta_daygroup;
  // Monday till Friday
  public DayOfWeek dayMeta_weekday;

  /** Is the day a holiday */
  public Boolean dayMeta_isHoliday;

  /** is this within the school holidays */
  public Boolean dayMeta_isSchoolVacation;

  /** Combined if schools are open - so no weekends, no corona school closing, holidays */
  public Boolean dayMeta_areSchoolsOpen;

  /* Pre post and in corona */
  public String pandemic;
  public String pandemic_schools;
  // if there is a "lockdown" and the intensity of the restrictions
  public Boolean pandemic_lockdown;
  /** The detailed restrictions */
  public List<String> pandemic_restrictions;



  // vehicle
  public String vehicle_id;
  public String vehicle_licencePlate;

  /** The section in the vehicle like a part of a train which is not accessible by walking */
  // TODO -discuss public String vehicle_section;

  /** The carriage or the part of a bus */
  // TODO -discuss public String vehicle_carriage;

  /** the section in a carriage like upper or lower deck */
  // TODO -discuss public String vehicle_carriage_section;

  /** the class of the vehicle or in the carriage */
  // TODO -discuss public String vehicle_class;

  /** the total standing passengers in the vehicle */
  public Integer vehicle_seats;
  public Integer vehicle_possibleStandingPassengers;

  // the operator driving the vehicle
  public String vehicle_operator;
  public String vehicle_operatorid;

  /** The door associated entries into the vehicle */
  public Double[] i_vehicle_door_entries;
  /** The door associated entries into the vehicle */
  public Double[] i_vehicle_door_exists;

  /** description if the door is a front door or */
  public String[] vehicle_door_meta;

  /** The entries into the vehicle regardless of which door */
  public Double i_boarding;
  /** The exits off the vehicle */
  public Double i_exits;
  /** How occupied did the vehicle arrive */
  public Double i_occupationArrival;
  public Double i_occupationDeparture;
  /** How long the ride took till the next stop - measure value not statistically */
  public Long i_timeTillNextStop;
  /** How long the ride took till the next stop - measure value not statistically */
  public Long i_timeFromLastStop;
  public Double i_origin_routeDistanceToLastStop;

  public String origin_stop_positionNaturalKey;
  public String destination_stop_positionNaturalKey;

  // the origin details and destination details are not needed and could be queried with subsequent
  // chained queries, but they are here for convenience reasons
  public String origin_stop_label;
  public String destination_stop_label;
  public Integer stopIndex;

  // the beginning stop of a line
  public boolean startStop;

  // the next station details
  public Double i_destination_entries;
  public Double i_destination_exists;
  public Double i_destination_retainers;
  /** entries plus exists - how much do the passengers change here */
  public Double i_absPassengerChange;
  /** The absolute growth or passengers or - "minus" values for decrease */
  public Double i_absPassengerGrowth;
  /** The non changing guests in the vehicle */
  public Double i_retainingGuests;

  // the previous station details
  public Double i_origin_entries;
  public Double i_origin_exists;
  public Double i_origin_retainers;

  public Double i_destination_routeDistanceToNextStop;
  // END FOUNDATION what has to be here before any processing



  /** real departure - real arrival */
  public Long i_totalStopDuration;
  /** The "real departure"- "planned stop" */
  public Long i_depatureStopDuration;
  /** The "real arrival"- "planned arrival" */
  public Long i_arrivalDelay;
  /** The "real departure"- "planned departure" */
  public Long i_departureDelay;


  /**
   * If the departure is delayed - On time = up to 5 minutes - Acceptable delay = 6 to 10 minutes -
   * Unacceptable delay = longer than 10 minutes
   */
  public EDelayPerception perception_departureDelay;
  /** if the arrival is delayed */
  public EDelayPerception perception_arrivalDelay;



  /** Stop duration/entries */
  public Double i_entranceSpeed;
  /** Stop duration/exits */
  public Double i_exitSpeed;



  // route data
  /** The delay when the route started */
  public Long i_route_startDelay;
  public Instant route_time_startPlanned;
  public Instant route_time_startReal;
  public Boolean route_startIsDelayed;

  /** if the date comes form a second data source and multiple records attribute the same fact */
  public String[] meta_alternateSources;
  /**
   * Manual counting, technical measurements or however the data was generated.
   */
  public String meta_dataOrigin;

  /**
   * The data transmitting organization. Does not mean the data is coming form this organization it
   * means just who transmitted the data to iunera.
   */
  public String meta_dataOriginOrganization;

  /** If the record is complete or if there are quality remarks */
  public List<String> meta_qualityRemarks;

  public Map<String, Object> additionalVendorValues;
  public Map<String, Object> additionalQAValues;
}
