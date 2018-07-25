package basics;

public class Playground {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
arrayAndLoopDemo();
	}
	
	static void arrayAndLoopDemo() {
		System.out.println("This is the array demo");
		String[] cities = {"Reson", "Atlanta", "Pittsburg"};
		
		int numOfCities = cities.length;
		System.out.println("There are " + numOfCities + " cities.");
		//initialize counter
		int counter = 0;
		
		System.out.println("DO WHILE LOOP");
		do {
			System.out.println(cities[counter]);
		counter++;
		} while   (counter < numOfCities);
		
		cities[2] = "Chicago";
		//for loop
		System.out.println("FOR LOOP");
		for(int i=0; i< numOfCities; i++) {
			System.out.println(cities[i]);
		}
	}

}
