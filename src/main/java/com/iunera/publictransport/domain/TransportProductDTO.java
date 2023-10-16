package com.iunera.publictransport.domain;


import java.util.EnumSet;
import java.util.MissingFormatArgumentException;
import java.util.Set;

import  com.fasterxml.jackson.annotation.JsonAutoDetect;
import  com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import  com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public enum TransportProductDTO
{
	HIGH_SPEED_TRAIN('I'), REGIONAL_TRAIN('R'), SUBURBAN_TRAIN('S'), SUBWAY('U'), TRAM('T'), BUS('B'), FERRY('F'), CABLECAR('C'), ON_DEMAND('P');

	public static final char UNKNOWN = '?';
	public static final Set<TransportProductDTO> ALL = EnumSet.allOf(TransportProductDTO.class);

	public final char code;

	private TransportProductDTO(final char code)
	{
		this.code = code;
	}

	public static TransportProductDTO fromCode(final char code)
	{
		if (code == HIGH_SPEED_TRAIN.code)
			return HIGH_SPEED_TRAIN;
		else if (code == REGIONAL_TRAIN.code)
			return REGIONAL_TRAIN;
		else if (code == SUBURBAN_TRAIN.code)
			return SUBURBAN_TRAIN;
		else if (code == SUBWAY.code)
			return SUBWAY;
		else if (code == TRAM.code)
			return TRAM;
		else if (code == BUS.code)
			return BUS;
		else if (code == FERRY.code)
			return FERRY;
		else if (code == CABLECAR.code)
			return CABLECAR;
		else if (code == ON_DEMAND.code)
			return ON_DEMAND;
		else
			throw new IllegalArgumentException("unknown code: '" + code + "'");
	}

	public static TransportProductDTO fromString(final String name)
	{
		if (name.equals(HIGH_SPEED_TRAIN.name()))
			return HIGH_SPEED_TRAIN;
		else if (name.equals(REGIONAL_TRAIN.name()))
			return REGIONAL_TRAIN;
		else if (name.equals(SUBURBAN_TRAIN.name()))
			return SUBURBAN_TRAIN;
		else if (name.equals(SUBWAY.name()))
			return SUBWAY;
		else if (name.equals(TRAM.name()))
			return TRAM;
		else if (name.equals(BUS.name()))
			return BUS;
		else if (name.equals(FERRY.name()))
			return FERRY;
		else if (name.equals(CABLECAR.name()))
			return CABLECAR;
		else if (name.equals(ON_DEMAND.name()))
			return ON_DEMAND;
		else
			throw new IllegalArgumentException("unknown name: '" + name + "'");
	}
	
	public static Set<TransportProductDTO> fromCodes(final char[] codes)
	{
		if (codes == null)
			return null;

		final Set<TransportProductDTO> products = EnumSet.noneOf(TransportProductDTO.class);
		for (int i = 0; i < codes.length; i++)
			products.add(TransportProductDTO.fromCode(codes[i]));
		return products;
	}

	public static char[] toCodes(final Set<TransportProductDTO> products)
	{
		if (products == null)
			return null;

		final char[] codes = new char[products.size()];
		int i = 0;
		for (final TransportProductDTO product : products)
			codes[i++] = product.code;
		return codes;
	}
	
	public static TransportProductDTO getFromGTFSType(int gtfsType) {
		if (gtfsType!=3) throw new MissingFormatArgumentException("Not Implemented yet");
		return BUS;
	}
	//TODO: Make it GTFS compliant
	/*public static getGTFSKey() {
		0 - Tram, Streetcar, Light rail. Any light rail or street level system within a metropolitan area.
		1 - Subway, Metro. Any underground rail system within a metropolitan area.
		2 - Rail. Used for intercity or long-distance travel.
		3 - Bus. Used for short- and long-distance bus routes.
		4 - Ferry. Used for short- and long-distance boat service.
		5 - Cable tram. Used for street-level rail cars where the cable runs beneath the vehicle, e.g., cable car in San Francisco.
		6 - Aerial lift, suspended cable car (e.g., gondola lift, aerial tramway). Cable transport where cabins, cars, gondolas or open chairs are suspended by means of one or more cables.
		7 - Funicular. Any rail system designed for steep inclines.
		11 - Trolleybus. Electric buses that draw power from overhead wires using poles.
		12 - Monorail. Railway in which the track consists of a single rail or a beam.
	}
	*/
	
}