package com.iunera.publictransport.domain;

/**
 * According to studies delays are not always recognized as delays by passengers. Therefore, this
 * enumeration lists the delay types that correspond with humanoid perception.
 */
public enum EDelayPerception {
  A_EARLY, B_WITHIN_1m, C_WITHIN_5m, D_WITHIN_10m, E_WITHIN_20m, F_EXCEEDING_20m;

  public static EDelayPerception getDelayPerception(long delayInSeconds) {

    if (delayInSeconds < 0)
      return A_EARLY;
    if (delayInSeconds - 1 * 60 < 0)
      return B_WITHIN_1m;
    if (delayInSeconds - 5 * 60 < 0)
      return C_WITHIN_5m;
    if (delayInSeconds - 10 * 60 < 0)
      return D_WITHIN_10m;
    if (delayInSeconds - 20 * 60 < 0)
      return E_WITHIN_20m;
    return F_EXCEEDING_20m;
  }
}
