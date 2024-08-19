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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/** Like the trip information from GTFS */
public class TripStopDepatureDetails {

  public String tripId;
  public String departureStopName;
  //	public String arrivalStopName;
  public String zoneId; // timeZone

  public String direction;
  public String routeId;
  public String routeShortName;
  public String routeLongName;
  public String departureStopId;
  //	public String arrivalStopId;

  // the validity operation date of timetable scheduled
  public LocalDate date;
  public LocalTime plannedDepartureTime;
  // public LocalTime plannedArrivalTime;

  public LocalDateTime plannedDepartureDateTime; // date+plannedDepartureTime
  //	public LocalDateTime plannedArrivalDateTime; // when larger then 24 hours then add ene day to
  // the operation date

  public String stopLatitude;
  public String stopLongitude;
}
