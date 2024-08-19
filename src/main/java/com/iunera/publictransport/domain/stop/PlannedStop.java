package com.iunera.publictransport.domain.stop;

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

import com.iunera.publictransport.domain.route.PlannedDeparture;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * An halting point.
 *
 * @see https://schema.org/BusStation Please beware that a stop can always be a member in a larger
 *     complex or have more detailed subtypes. Imagine a large bus station with many platforms and
 *     so on and compare it with a simple busstop. For the sake of simplicity the stop object here
 *     shall represent all of such possibilities and refer to the human perception of what the bus
 *     stop is named, regardless if there is one or many platforms. Later versions may specialize
 *     this class further.
 */
public class PlannedStop implements Serializable {

  public static final long serialVersionUID = 1L;

  public PlannedStop() {}

  public PlannedStop(
      String name,
      double longitude,
      double latitude,
      String IFOPT,
      String direction,
      String... alternativeNames) {
    super();
    this.name = name;
    if (alternativeNames != null) for (String s : alternativeNames) this.alternativeNames.add(s);
    this.direction = direction;
    this.longitude = longitude;
    this.latitude = latitude;
    this.IFOPT = IFOPT;
  }

  public String name;

  public Set<String> alternativeNames = new HashSet<>();

  // A parent station can have multiple departure points
  public boolean isParent;

  public double longitude;
  public double latitude;

  public String direction;

  public String IFOPT;

  public String parentStationIFOPT;

  public List<PlannedDeparture> plannedDepartures;

  public String stopAbbreviation;
}
