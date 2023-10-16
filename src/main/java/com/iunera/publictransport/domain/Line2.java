package com.iunera.publictransport.domain;


import java.io.Serializable;
import java.util.List;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.MultiLineString;

public class Line2 implements Serializable{
 
	public Line2() {
	}
	
	// the inverse line
	public Line2 inverse;

	public List<Coordinate> platformsNodes;
	public List<Geometry> platformWays ;
	public List<Coordinate> stopNodes;
	public MultiLineString route;
	
	// a linetype is if the line is cyclic, if it is splitting into different lines
	//public ELinetype

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
	
	public String line_long_name; //=route_long_name;
	public String line_routeid; //=route_id;
	public String line; //=route_short_name;
	public String line_id; //=route_id;
	public String trip_id; //=trip_id;

	public Stop stop;
	
	public String getDirection(Coordinate one, Coordinate ...two) {
		return "1";
	}
	
	
	public EStopType getPositionType(Coordinate toTest) { 
		Coordinate lineEndStop = this.stopNodes.get(this.stopNodes.size() - 1);
		Coordinate lineStartStop = this.stopNodes.get(0);

		// check if it is an end stop
		double distanceEnd = lineEndStop.distance(toTest);
		double distanceStart = lineStartStop.distance(toTest);
		EStopType type=null;
		// 44 m -0.0001--11m
		if (distanceEnd < 0.0004 ) {
			type = EStopType.END;

		}
		if(distanceStart< 0.0004) {		
			if(type!=null) type = EStopType.STARTEND;
			else type=EStopType.START;
			
		}
		
		if(type==null) {
			for(Coordinate stop:this.stopNodes) {
				if(stop.distance(toTest)< 0.0004) {
					type=EStopType.NORMAL;
					break;
				}
			}
		}
		
		if(type==null) type= EStopType.NOSTOP;
		
		return type;
		
		
	}

}
