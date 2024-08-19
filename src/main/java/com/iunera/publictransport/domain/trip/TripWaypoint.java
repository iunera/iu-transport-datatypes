package com.iunera.publictransport.domain.trip;

/*-
 * #%L
 * iu-transport-datatypes
 * %%
 * Copyright (C) 2024 Tim Frey, Christian Schmitt
 * %%
 * Licensed under the OPEN COMPENSATION TOKEN LICENSE (the "License").
 *
 * You may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 * <https://github.com/open-compensation-token-license/license/blob/main/LICENSE.md>
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either expressed or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * @octl.sid: 1b6f7a5d-8dcf-44f1-b03a-77af04433496
 * #L%
 */

import com.iunera.publictransport.domain.EDayGroup;
import com.iunera.publictransport.domain.TransportProductDTO;
import com.iunera.publictransport.domain.route.Route;
import com.iunera.publictransport.domain.stop.ExecutedStop;
import com.iunera.publictransport.domain.stop.PlannedStop;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Map;

public class TripWaypoint implements Serializable {

  public TransportProductDTO line_transportProduct;
  /** The legal entity providing the data to be able to filter the data later for it */
  public String meta_provider;

  // the partition in which this event was ingested - this can be a filename or a request path
  public String meta_ingestionPartition;

  // private static final long serialVersionUID = 8157338761722444547L;
  /** The unique ID of the record - */
  public String event_Id;

  public EventType event_Type;

  /** OPTIONAL a subtype of an event */
  public String event_Subtype;

  /** OPTIONAL: The logical operation date of the ride. E.g. for 1 am it might be the date before */
  public LocalDate time_operationDate;

  /** The timestamp when the event appeared */
  public Instant time;

  public Instant time_end;
  /** additional event details that can differ for each subeventtype */
  public Map<String, Object> eventDetails;

  /** The result of a people count */
  public static String eventSubtypePeopleCount = "PeopleCount";
  /** an in between result before the complete people count is finished */
  public static String eventSubtypeInterimPeopleCountMESSAGE = "InterimPeopleCount";

  public static String eventSubtypeGPSUpdateWAYPOINT = "GPSUpdate";
  public static String eventSubtypeDoorOpenSTOPEVENT = "DoorOpen";
  public static String eventSubtypeDoorCloseSTOPEVENT = "DoorClose";
  public static String eventSubtypeInitionOnSTOPEVENT = "InitionOn";
  public static String eventSubtypeInitionOffSTOPEVENT = "InitionOff";
  public static String eventSubtypeMessageDeviceIDMESSAGE =
      "MessageDeviceID"; // vehicleCountingSystemId
  public static String eventSubtypeMessageERRORMESSAGE = "MessageERROR";
  public static String eventSubtypeStopZone = "StopZone";

  public Vehicle vehicle;

  public long vehicle_currentOdometerValue; // Km_Stand
  public long
      vehicle_operationminute; // the operation minute of a vehicle since ignition started to
  // compute

  /**
   * Indicator if the waypoint or stopevent is near an official bus stop. Busses may stop without
   * official stops e.g. to let a granny out at the doctor or similar Busses might just drive
   * through a busstop when nobody is there without event stopping Hence, this variable indicates
   * that the event happened near a busstop.
   */
  public boolean stop_hasOfficalStopProximity;
  /*The details of the stop - where the vehicle was planned to stop - however, the real data can be away a bit form the stop e.g. the time does not match and so on*/
  public PlannedStop stop_scheduleStop;
  public ExecutedStop stop_executedStop;
  // this is available for Lemgo
  public String stop_name;
  public Integer stop_route_Index;
  public String stop_Point; // Haltepunkt_Nr

  // TODO
  public Instant stop_time_arrivalPlan;
  public Instant stop_time_arrivalReal;
  public Instant stop_time_departurePlan;
  public Instant stop_time_departureReal;
  public Long stop_timedureationsinceLastStop;

  /*
   * likely not needed The counting system used e.g. countingSystemMGElectronic
   */
  // public String countingSystem;
  // public static String countingSystemMGElectronic="MGElectronic";
  // public String countingSystemVersion;

  public String geo_Hash;
  public Double geo_longitude;
  public Double geo_latitude;
  public String geo_direction;

  /** OPTIONAL: If available the line the vehicle is driving on */
  public String routeName;

  public Route routeDetails;

  ////////////////////////////////////////////
  // event specific extensions

  /** Only in the stop event Map<DOOR, EntryExitActivity> Strings can be DOOR1..DOORn */
  public Map<String, EntryExitActivity> i_occupancy_doorEntryExitActivity;

  public Double i_occupationDeparture;
  public Double i_occupationArrival;

  /** The door associated entries into the vehicle */
  public Double[] i_total_boarding;

  public Double[] i_total_door_exits;
  public Integer i_occupancy_delta;
  public Double i_retainers;

  public Double i_lastStop_boarding;
  public Double i_lastStop_exists;
  public Double i_lastStop_retainers;
  public Double i_absPassengerChange;
  /** The absolute growth or passengers or - "minus" values for decrease */
  public Double i_absPassengerGrowth;

  public Long i_arrivalDelay;
  public Long i_departureDelay;

  public TripWaypoint() {}

  public TripWaypoint(
      EventType eventType,
      String eventSubtype,
      String provider,
      Double latitude,
      Double longitude,
      LocalDate operationDate,
      Instant timeStamp,
      String vehicleCountingSystemId,
      String vehicleId,
      String licensePlate,
      String line, // String ingestionPartition,
      Map<String, EntryExitActivity> doorEntryExitActivity,
      String stopName) {
    super();
    this.event_Type = eventType;
    this.event_Subtype = eventSubtype;
    this.meta_provider = provider;
    this.geo_longitude = longitude;
    this.geo_latitude = latitude;
    this.time_operationDate = operationDate;
    this.time = timeStamp;
    this.vehicle = new Vehicle();
    this.vehicle.vehicle_CountingSystemId = vehicleCountingSystemId;
    this.vehicle.vehicle_Id = vehicleId;
    this.vehicle.vehicle_licensePlate = licensePlate;
    this.routeName = line;
    // this.ingestionPartition = ingestionPartition;
    this.i_occupancy_doorEntryExitActivity = doorEntryExitActivity;
    this.stop_name = stopName;
  }

  /**
   * The hour of the day for simplified queries. Can be used as query for hourly histograms, easily.
   * Zoned to the timezone of the departure
   */
  public Integer event_time_zonedHour;
  /**
   * The natural identifier for this recurring ride. Each ride at the same time on a different day
   * will have the same key when it is panned to stop within 100m at the same stop.
   */
  public String geo_time_dailyRideStopKey;

  // weekday or weekend
  public EDayGroup time_daygroup;
  // Monday till Friday
  public DayOfWeek time_weekday;
  /** Is the day a holiday */
  public Boolean time_isHoliday;
  /** is this within the school holidays */
  public Boolean time_isSchoolVacation;
  /** Combined if schools are open - so no weekends, no corona school closing, holidays */
  public Boolean time_areSchoolsOpen;
}
