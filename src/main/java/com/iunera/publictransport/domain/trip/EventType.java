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

public enum EventType {
  /** An event that appears generally on the road */
  WAYPOINT,

  /**
   * The vehicle halted - not known if it is a specific stop but the doors opened - can be detected
   * as a planned stop later
   */
  STOPDOORSOPEN,

  /** An event that appears during when the vehicle is halted */
  PLANNEDSTOP,

  /** An event that appears during when the vehicle is halted at a non declared stop */
  UNPLANNEDSTOP,
  /**
   * An event that indicates an message - such a message can be an error or also a version of a
   * serial version of a system
   */
  MESSAGE
}
