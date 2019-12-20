package animalrace;

public class Food {
	
	public synchronized void eat(int eatingTime, String name) {
		System.out.println(name + " is eating!");
		try {
			Thread.sleep(eatingTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name + " is done eating!");
	}

	
}
