package animalrace;
import java.util.Random;

public class Animal implements Runnable {
	
	Random rand = new Random();
	public Food food;
	public String name;
	public int position;
	public int speed;
	public int maxRest;
	public int eatingTime;
	public static boolean winner = false;
	
	public Animal(String animalName, int animalSpeed, int animalMaxRest, Food food, int eatingTime) {
		this.name = animalName;
		this.position = 0;
		this.speed = animalSpeed;
		this.maxRest = animalMaxRest;
		this.eatingTime = eatingTime;
		this.food = food;
	}
	
	public void run() {
		while(position < 100) {
			
			position += speed;
			try {
				Thread.sleep(rand.nextInt(maxRest));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("The " + name + " is in position " + position);
			food.eat(eatingTime, name);
		}
		Animal.winner = true;
		System.out.println("The " + name + " is the winner!");
	}
	
	public static void main(String[] args) {
//		Animal rabbit = new Animal("rabbit", 5, 150);
//		Animal turtle = new Animal("turtle", 3, 100);
		Food food = new Food();
		(new Thread(new Animal("rabbit", 5, 150, food, 100))).start();
		(new Thread(new Animal("turtle", 3, 100, food, 50))).start();
	}
}
