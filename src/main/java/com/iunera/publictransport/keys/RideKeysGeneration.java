package com.iunera.publictransport.keys;

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

import ch.hsr.geohash.GeoHash;
import com.iunera.publictransport.domain.TransportProductDTO;
import java.time.LocalTime;

public class RideKeysGeneration {

  public static String CoordinateFunctionStop = "stop";
  public static String directionUNKNOWN = "UNKNOWN";

  /**
   * Returns a minute based key for the ride that shall be unique in the following sense: Only one
   * bus of one line can be scheduled to leave in in minute of a day within 110m
   */
  public static String getRideDayKeyForStop(
      Double longitude,
      Double latitude,
      LocalTime depaturetime,
      String linelabel,
      TransportProductDTO transportProduct) {

    return getNearestTimeBucketsKeys(
        CoordinateFunctionStop,
        longitude,
        latitude,
        3,
        depaturetime,
        linelabel,
        transportProduct,
        directionUNKNOWN,
        1)[1];
  }

  /**
   * * Generates a unique key for a stop use the planned longitude and the planned latitude.. This
   * is important that if there is a temporary shift out of a construction work or similar and still
   * to have a match.
   */
  public static String getKeyForStop(
      Double longitude, Double latitude, TransportProductDTO transportProduct, String direction) {
    // 0.0001--11m String theDigits = ;

    return getKey(
            CoordinateFunctionStop, longitude, latitude, 7, null, null, transportProduct, direction)
        .toString();
  }

  /**
   * returns IDs containing the nearest time buckets for a ride. Often rides can be shifted by
   *
   * @param precision 1 ± 2500 km 2 ± 630 km 3 ± 78 km 4 ± 20 km 5 ± 2.4 km 6 ± 610m 7 ± 76m 8 ± 19m
   *     9 ± 2,4 10 ± 60cm 11 ± 7,4 cm
   */
  public static String[] getNearestTimeBucketsKeys(
      String coordinateFunction,
      Double longitude,
      Double latitude,
      int precision,
      LocalTime depaturetime,
      String linelabel,
      TransportProductDTO transportProduct,
      String direction,
      int bucketsizeInMinutes) {

    StringBuilder sb =
        RideKeysGeneration.getKey(
            coordinateFunction,
            longitude,
            latitude,
            precision,
            depaturetime,
            linelabel,
            transportProduct,
            direction);

    sb.append(":bucketsizeInMinutes:");
    sb.append(bucketsizeInMinutes);
    sb.append(":bucket:");
    Integer minute = depaturetime.toSecondOfDay() / 60;
    int upperboundminute = 0;
    int lowerboundminute = 0;
    int middleboundminute = ((minute / bucketsizeInMinutes) * bucketsizeInMinutes);

    if ((middleboundminute + bucketsizeInMinutes) > (24 * 60)) {
      upperboundminute = ((middleboundminute + bucketsizeInMinutes) - (24 * 60));
    } else {
      upperboundminute = (middleboundminute + bucketsizeInMinutes);
    }

    if ((middleboundminute - bucketsizeInMinutes) < 0) {
      lowerboundminute = ((middleboundminute - bucketsizeInMinutes) + (24 * 60));
    } else {
      lowerboundminute = (middleboundminute - bucketsizeInMinutes);
    }

    return new String[] {
      new StringBuilder(sb).append(lowerboundminute).toString(),
      new StringBuilder(sb).append(middleboundminute).toString(),
      new StringBuilder(sb).append(upperboundminute).toString()
    };
  }

  private static StringBuilder getKey(
      String coordinateFunction,
      Double longitude,
      Double latitude,
      int precision,
      LocalTime depaturetime,
      String linelabel,
      TransportProductDTO transportProduct,
      String direction) {
    StringBuilder sb = new StringBuilder();

    sb.append(transportProduct);

    if (linelabel != null) {
      sb.append(":");
      // add only the line numbers and not letters
      sb.append(linelabel.replaceAll("\\D+", ""));
    }
    sb.append(":coordinateFunction:");
    sb.append(coordinateFunction);
    sb.append(":geoHashPrecision:");
    sb.append(precision);
    sb.append(":");
    sb.append(GeoHash.geoHashStringWithCharacterPrecision(latitude, longitude, precision));

    if (direction != null) {
      sb.append(":direction:");
      sb.append(direction);
    }
    return sb;
  }
}
