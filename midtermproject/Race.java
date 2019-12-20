package midtermproject;



public class Race {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 10; i++) {
			(new Thread(new RaceCar(350, 2000, 5, "GTR"))).start();
			(new Thread(new RaceCar(400, 2500, 5, "911 Carrera"))).start();
			(new Thread(new RaceMotorcycle(400, 2500, 5, "Ducati"))).start();
		}
	}

}
