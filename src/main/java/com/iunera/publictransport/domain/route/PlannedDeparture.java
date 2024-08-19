package com.iunera.publictransport.domain.route;

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
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class PlannedDeparture implements Serializable {

  public PlannedDeparture() {}

  public PlannedDeparture(
      LocalTime deparatureTime, String direction, String line_id, String lineLabel) {
    this.deparatureTime = deparatureTime;
    this.direction = direction;
    this.line_id = line_id;
    this.line_label = lineLabel;
  }

  public LocalTime deparatureTime;
  public String direction;
  public String line_id;
  public String line_label;

  public List<LocalDate> additionalDepatureDates;
  public List<LocalDate> excludedDepatureDates;

  public List<DayOfWeek> depatureWeekdays;
  public List<LocalDate> depatureWeekdaysValidFrom;
  public List<LocalDate> depatureWeekdaysValidTo;
}
