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

public class NaturalKeyGen {

  /**
   * @param longitude
   * @param latitude
   * @param labelLineKey The key of the provider that might be the same for other providers like
   *     ("768") or for different means of transport
   * @param transportProductDTO the transport product
   * @param precison the georegion precision - 1 ± 2500 km 2 ± 630 km 3 ± 78 km 4 ± 20 km 5 ± 2.4 km
   *     6 ± 610m 7 ± 76m 8 ± 19m 9 ± 2,4 10 ± 60cm 11 ± 7,4 cm
   * @return A key that is likely unique globally if there are no equal line labels within the
   *     precison KM
   */
  public static String getLineGeoKey(
      double longitude,
      double latitude,
      String labelLineKey,
      TransportProductDTO transportProductDTO,
      int precision) {
    return "precision:"
        + precision
        + ":regiongeoHash:"
        + GeoHash.geoHashStringWithCharacterPrecision(latitude, longitude, precision)
        + ":labelLineKey:"
        + labelLineKey
        + ":transportProduct:"
        + transportProductDTO.name();
  }

  public static int DEFAULT_PRECISION = 3;
}
