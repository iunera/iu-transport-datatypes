package com.iunera.publictransport.domain;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Map;


public class RideEvent implements Serializable {

  // private static final long serialVersionUID = 8157338761722444547L;



  /**
   * 
   */
  private static final long serialVersionUID = -8003495810477113117L;

  /**
   * Indicator if the waypoint or stopevent is near an official bus stop. Busses may stop without
   * official stops e.g. to let a granny out at the doctor or similar Busses might just drive
   * through a busstop when nobody is there without event stopping Hence, this variable indicates
   * that the event happened near a busstop.
   */
  public boolean hasOfficalStopProximity;

  /*
   * likely not needed The counting system used e.g. countingSystemMGElectronic
   */
  // public String countingSystem;
  // public static String countingSystemMGElectronic="MGElectronic";
  // public String countingSystemVersion;

  public String geoHash;

  public EventType eventType;

  /** OPTIONAL a subtype of an event */
  public String eventSubtype;

  /**
   * The result of a people count
   */
  public static String eventSubtypePeopleCount = "PeopleCount";
  /**
   * an in between result before the complete people count is finished
   */
  public static String eventSubtypeInterimPeopleCountMESSAGE = "InterimPeopleCount";
  public static String eventSubtypeGPSUpdateWAYPOINT = "GPSUpdate";
  public static String eventSubtypeDoorOpenSTOPEVENT = "DoorOpen";
  public static String eventSubtypeDoorCloseSTOPEVENT = "DoorClose";
  public static String eventSubtypeInitionOnSTOPEVENT = "InitionOn";
  public static String eventSubtypeInitionOffSTOPEVENT = "InitionOff";
  public static String eventSubtypeMessageDeviceIDMESSAGE = "MessageDeviceID";// vehicleCountingSystemId
  public static String eventSubtypeMessageERRORMESSAGE = "MessageERROR";
  public static String eventSubtypeStopZone = "StopZone";


  /**
   * The legal entity providing the data to be able to filter the data later for it
   */
  public String provider;

  // the partition in which this event was ingested - this can be a filename or a request path
  public String ingestionPartition;

  public Double longitude;
  public Double latitude;

  /**
   * OPTIONAL: The logical operation date of the ride. E.g. for 1 am it might be the date before
   */
  public LocalDate operationDate;

  /** The timestamp when the event appeared */
  public Instant timeStamp;

  public Instant endTimeStamp;

  public String uniqueVehicleId() {
    if (this.vehicleCountingSystemId != null)
      return this.vehicleCountingSystemId;
    if (this.licensePlate != null)
      return this.licensePlate;

    throw new IllegalAccessError("Vehicle does not have a unqiue ID");
  }

  /**
   * The unique ID of the counting system installation - the unique ID of the counting system in the
   * vehicle Serial number of the complete vehicle counting system
   */
  public String vehicleCountingSystemId = null;

  /**
   * OPTIONAL:The unique ID of of the vehicle
   */
  public String vehicleId;

  /** OPTIONAL: if available the license plate f the vehicle */
  // considered routeNumber for Ilmenau
  public String licensePlate;

  /** OPTIONAL: If available the line the vehicle is driving on */
  public String line;

  public Line2 lineDetails;

  ////////////////////////////////////////////
  // event specific extensions

  /**
   * Only in the stop event Map<DOOR, EntryExitActivity> Strings can be DOOR1..DOORn
   */
  public Map<String, EntryExitActivity> doorEntryExitActivity;

  public Integer deltaOccupancy;

  public Integer cleanedOccupancy;
  // the complete aggregated entry exit activity
  // public EntryExitActivity completeStopEntryExitActivity;

  /** additional event details that can differ for each subeventtype */
  public Map<String, Object> eventDetails;

  // this is available for Lemgo
  public String stopName;

  public Stop stop;

  public Integer stopIndex;

  public RideEvent() {}

  public RideEvent(EventType eventType, String eventSubtype, String provider, Double latitude,
      Double longitude, LocalDate operationDate, Instant timeStamp, String vehicleCountingSystemId,
      String vehicleId, String licensePlate, String line, // String ingestionPartition,
      Map<String, EntryExitActivity> doorEntryExitActivity, String stopName) {
    super();
    this.eventType = eventType;
    this.eventSubtype = eventSubtype;
    this.provider = provider;
    this.longitude = longitude;
    this.latitude = latitude;
    this.operationDate = operationDate;
    this.timeStamp = timeStamp;
    this.vehicleCountingSystemId = vehicleCountingSystemId;
    this.vehicleId = vehicleId;
    this.licensePlate = licensePlate;
    this.line = line;
    // this.ingestionPartition = ingestionPartition;
    this.doorEntryExitActivity = doorEntryExitActivity;
    this.stopName = stopName;
  }

}
