import java.util.Scanner;

public class Station {

	private PassengerQueue firstClass;
	private PassengerQueue secondClass;
	private BooleanSource firstArrival;
	private BooleanSource secondArrival;
	private String name;
	private boolean firstNewArrival;
	private boolean secondNewArrival;
	private int time;
	
	
	public Station() {
	firstClass = new PassengerQueue();
	secondClass = new PassengerQueue();
	firstNewArrival=false;
	secondNewArrival=false;
	time=-1;
	}
	
	public void setArrivalRates(Scanner in) {
		
		System.out.println("Please enter first class arrival probability:");
		this.firstArrival = new BooleanSource(in.nextDouble());
		System.out.println("Please enter second class arrival probability:");
		this.secondArrival= new BooleanSource(in.nextDouble());
	}
	
	public void simulateTimestep() {
		time++;
		firstNewArrival=false;
		secondNewArrival=false;
		
		if(firstArrival.occurs()) {
			firstClass.enqueue(new Passenger());
			firstClass.getQueue().getLast().setIsFirstClass(true);
			firstClass.getQueue().getLast().setArrivalTime(time);
			firstNewArrival=true;
		}
		if(secondArrival.occurs()) {
			secondClass.enqueue(new Passenger());
			secondClass.getQueue().getLast().setIsFirstClass(false);
			secondClass.getQueue().getLast().setArrivalTime(time);
			secondNewArrival=true;
		}
	
	}
	
	public boolean[] getNewArrivals() {
		boolean[] r = new boolean[2];
		/*if(firstNewArrival) {
			r[0] = true;
		}
		else r[0] = false;
		if(secondNewArrival) {
			r[1] = true;
		}
		else r[1] = false;*/
		
		r[0] = firstNewArrival;
		r[1] = secondNewArrival;
		
		return r;
	}
	
	public PassengerQueue getFirstQueue() {
		return firstClass;
	}
	public PassengerQueue getSecondQueue() {
		return secondClass;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String toString() {
		String r = "\n" + name + ":";
		
		if(firstNewArrival) {
			r += "\nFirst class passenger ID " + firstClass.getQueue().getLast().getId() + " arrives"; //possible error from last being first
		}
		else {
			r+="\nNo first class passenger arrives";
		}
		
		if(secondNewArrival) {
			r += "\nSecond class passenger ID " + secondClass.getQueue().getLast().getId() + " arrives"; //possible error from last being first
		}
		else {
			r+="\nNo second class passenger arrives";
		}
		
		r+="\nQueues:";
				
		if(firstClass.getQueue().isEmpty()) {
			r+= "\nFirst [empty]";
		}
		else {
			r+= firstClass.toString();
		}
		
		if(secondClass.getQueue().isEmpty()) {
			r+= "\nSecond [empty]";
		}
		else {
			r+= secondClass.toString();
		}
		return r;
	}
	
	public String getName() {
		return name;
	}
	
}
