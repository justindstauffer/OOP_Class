package midtermproject;

import java.io.FileWriter;
import java.io.IOException;

public class WriteResults {
	FileWriter out = null;
	public synchronized void writeResults(String vehicleName, int raceTime) {
		try {
			out = new FileWriter("raceResults.txt");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			out.write(vehicleName + " " + raceTime);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
