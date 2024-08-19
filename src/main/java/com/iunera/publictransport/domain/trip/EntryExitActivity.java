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

public class EntryExitActivity {

  public double boarding;
  public double exiting;

  public EntryExitActivity() {}

  public EntryExitActivity(double boarding, double exiting) {
    this.boarding = boarding;
    this.exiting = exiting;
  }

  /** door id or door number */
  public String[] vehicle_door_meta;
}
