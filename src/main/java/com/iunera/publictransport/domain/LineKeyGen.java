package com.iunera.publictransport.domain;

import ch.hsr.geohash.GeoHash;

public class LineKeyGen {

  /**
   * @param longitude
   * @param latitude
   * @param labelLineKey The key of the provider that might be the same for other providers like
   *        ("768") or for different means of transport
   * @param transportProductDTO the transport product
   * @param precision the georegion precision - 1 ± 2500 km 2 ± 630 km 3 ± 78 km 4 ± 20 km 5 ± 2.4 km
   *        6 ± 610m 7 ± 76m 8 ± 19m 9 ± 2,4 10 ± 60cm 11 ± 7,4 cm
   * @return A key that is likely unique globally if there are no equal line labels within the
   *         precison KM
   */
  public static String getGeoKey(double longitude, double latitude, String labelLineKey,
      TransportProductDTO transportProductDTO, int precision) {
    return "precision:" + precision + ":regiongeoHash:"
        + GeoHash.geoHashStringWithCharacterPrecision(latitude, longitude, precision)
        + ":labelLineKey:" + labelLineKey + ":transportProduct:" + transportProductDTO.name();
  }

  public static int DEFAULT_PRECISION = 3;
}
