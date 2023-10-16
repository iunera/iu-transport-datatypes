package com.iunera.publictransport.domain;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Stop implements Serializable{
	
	public static final long serialVersionUID = 1L;

	public Stop() {}
	
	public Stop(String name, double longitude, double latitude,String IFOPT, String direction,
			String ...alternativeNames ) {
		super();
		this.name = name;
		if(alternativeNames!=null) for(String s:alternativeNames)this.alternativeNames.add(s);
		this.direction=direction;
		this.longitude = longitude;
		this.latitude = latitude;
		this.IFOPT=IFOPT;
	}

	public String name;
	
	//public String id;
	
	public Set<String> alternativeNames= new HashSet<>();
	
	// A parent station can have multiple departure points
	public boolean isParent;
	
	public double longitude;
	public double latitude;
	
	public String direction;
	
	public String IFOPT;
	
	public String parentStationIFOPT;
	
	public List<PlannedDeparture> plannedDepartures;
	
	

}
