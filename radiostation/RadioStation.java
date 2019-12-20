package radiostation;

public class RadioStation {
	String stationCallSign;
	double stationFrequency;
	
	public RadioStation(String callSign, double frequency) throws RadioStationException {
		stationCallSign = callSign;
		stationFrequency = frequency;
		
		if(callSign.length() != 4) {
			throw new RadioStationException("This radio call sign doesnt exist.",stationCallSign, stationFrequency);
		} 
		if(stationFrequency < 88 || stationFrequency > 108) {
			throw new RadioStationException("This frequency is outside of the 88-108 window.",stationCallSign, stationFrequency);
		}
	}
}
