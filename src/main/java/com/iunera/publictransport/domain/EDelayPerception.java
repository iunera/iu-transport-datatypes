package com.iunera.publictransport.domain;

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

/**
 * According to studies delays are not always recognized as delays by passengers. Therefore, this
 * enumeration lists the delay types that correspond with humanoid perception.
 */
public enum EDelayPerception {
  A_EARLY,
  B_WITHIN_1m,
  C_WITHIN_5m,
  D_WITHIN_10m,
  E_WITHIN_20m,
  F_EXCEEDING_20m;

  public static EDelayPerception getDelayPerception(long delayInSeconds) {

    if (delayInSeconds < 0) return A_EARLY;
    if (delayInSeconds - 1 * 60 < 0) return B_WITHIN_1m;
    if (delayInSeconds - 5 * 60 < 0) return C_WITHIN_5m;
    if (delayInSeconds - 10 * 60 < 0) return D_WITHIN_10m;
    if (delayInSeconds - 20 * 60 < 0) return E_WITHIN_20m;
    return F_EXCEEDING_20m;
  }
}
