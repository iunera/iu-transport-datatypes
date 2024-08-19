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

import com.iunera.publictransport.domain.TransportProductDTO;
import java.io.Serializable;
import java.util.List;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.MultiLineString;

public class Route implements Serializable {

  public static final long serialVersionUID = 1L;

  public Route() {}

  // the inverse line in case there is the same line in the opposite direction - otherwise null
  public Route inverse;
  // TODO: FUTURE: a line type is if the line is cyclic, if it is splitting into different lines
  // public ELinetype

  public List<Coordinate> platformsNodes;
  public List<Geometry> platformWays;
  public List<Coordinate> stopNodes;
  public MultiLineString route;

  public String lineName;
  public String lineLabel;

  public String textRouteDirection;
  public TransportProductDTO transportProduct;

  public String from;
  public String to;

  public String lineRef;
  public String color;
  public String network;
  public String operator;

  public String line_long_name;
  public String line_routeid;
  public String line;
  public String line_id;
  public String trip_id;
  public String route_text_color;
  public String route_type;
}
