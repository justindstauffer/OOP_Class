package radiostation;

public class RadioStationException extends Exception {
	
	private String callSign;
	private double frequency;

	public RadioStationException(String message, String callSign, double cFrequency) {
		super(message);
		this.callSign = callSign;
		this.frequency = cFrequency;
	}
	public String getCallSign() {
		return callSign;
	}
	public double getFrequency() {
		return frequency;
	}
}
