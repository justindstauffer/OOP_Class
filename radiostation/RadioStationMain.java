package radiostation;

import java.util.Scanner;

public class RadioStationMain {

	public static void main(String[] args) {
		RadioStation[] theStations = new RadioStation[6];
		Scanner myScanner = new Scanner(System.in);
		System.out.println("We are creating 6 new radio stations");
		System.out.println("Radio stations have call signs with 4 characters(e.g. WJRR)");
		System.out.println("Radio stations frequencies fall between 88-108(e.g. 101.1)");
		System.out.println("---------------------------------------------------------------");
		for(int i = 0; i < 6; i++) {
			System.out.println("Radio Station #"+ (i+1));
			System.out.println("Enter the radio station call sign:");
			String callSign = myScanner.nextLine();
			System.out.println("Enter the radio station frequency:");
			double theFrequency = Double.parseDouble(myScanner.nextLine());
			
			try {
				theStations[i] = new RadioStation(callSign, theFrequency);
				System.out.println("Radio station #" +(i+1) + " was created successfully." );
				System.out.println("---------------------------------------------------------------");
			} catch (RadioStationException e) {
				System.out.println("The call sign " + e.getCallSign() + " and frequency " + e.getFrequency() + " do not create a valid station.");
				System.out.println("Station #" + (i+1) + " was not successfully created.");
//				e.printStackTrace();
			} catch (Exception e) {
				System.out.println("Radio station #" + (i+1) + " was not successfully created.");
			}
		}
		myScanner.close();

	}

}
