package midtermproject;
import java.util.Random;
import java.text.DecimalFormat;
import java.io.*;

public class Vehicle implements Racing, Runnable{
	public int horsePower;
	public String vehicleName;
	public int raceTime;
	public int weight;
	public double position;
	public double acceleration;
	public int shiftAccuracy;
	public int gear = 1;
	public int gears;
	Random rand = new Random();
	private static DecimalFormat df2 = new DecimalFormat("#.00");
	
	public Vehicle(int vehicleHP, int vehicleWeight, int gears, String name) {
		this.position = 0;
		this.horsePower = vehicleHP;
		this.weight = vehicleWeight;
		this.vehicleName = name;
		this.gears = gears;
	}
	
	public double getAcceleration() {
		return this.acceleration;
	}
	
	public void startAcceleration() {
		double weight = this.weight;
		double hp = this.horsePower;
		
		this.acceleration = weight/hp;
	}
	
	public void setAcceleration(double percentChange) {
		this.acceleration *= percentChange;
	}
	
	public void shift() {
		this.shiftAccuracy = rand.nextInt(100);
	}
	
	public void accelerate(double acceleration) {
		this.position += acceleration;
	}
	
	public void run() {
		
		startAcceleration();
		System.out.println(vehicleName + " takes off with an acceleration of: " + df2.format(acceleration));
		int whenToShift = 75;
		while(position < raceDistance) {
			raceTime++;
			accelerate(getAcceleration());
			System.out.println(vehicleName + " is at " + df2.format(position) + " / 440yrds");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(position > whenToShift && gear <= gears) {
				shift();
				if(shiftAccuracy > 15 ) {
					System.out.println(vehicleName + ", Good Shift!");
					setAcceleration(1.25);
				} else {
					System.out.println(vehicleName + ", Bad Shift!");
					setAcceleration(0.75);
				}
				gear++;
				whenToShift += 75;
				System.out.println(vehicleName + " is accelerating at: " + df2.format(acceleration));
			}
		}
		if(position >= raceDistance) {
			System.out.println(vehicleName + " passed the finish line with race time: "+ raceTime);
			try {
				BufferedWriter out = new BufferedWriter(new FileWriter("raceResults.txt", true));
				out.append(vehicleName + ", " + raceTime);
				out.newLine();
				out.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
}
