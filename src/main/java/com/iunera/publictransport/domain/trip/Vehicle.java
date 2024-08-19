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

import java.io.Serializable;

/** representing vehicle metadata */
public class Vehicle implements Serializable {
  // vehicle
  public String vehicle_id;
  public String vehicle_licencePlate;

  public String vehicle_emissions;
  /** the total standing passengers in the vehicle */
  public Integer vehicle_seats;

  public Integer vehicle_possibleStandingPassengers;

  // the operator driving the vehicle
  public String vehicle_operator;
  public String vehicle_operatorid;

  /**
   * The unique ID of the counting system installation - the unique ID of the counting system in the
   * vehicle Serial number of the complete vehicle counting system
   */
  public String vehicle_CountingSystemId = null;
  /** OPTIONAL:The unique ID of of the vehicle */
  public String vehicle_Id;

  /** OPTIONAL: if available the license plate f the vehicle */
  // considered routeNumber for Ilmenau
  public String vehicle_licensePlate;

  public String vehicle_uniqueId() {
    if (this.vehicle_CountingSystemId != null) return this.vehicle_CountingSystemId;
    if (this.vehicle_licensePlate != null) return this.vehicle_licensePlate;

    throw new IllegalAccessError("Vehicle does not have a unqiue ID");
  }
}
