import java.util.ArrayList;
import java.util.LinkedList;

public class Train {

	private LinkedList<Station> stations;
	private int firstCapacity; //capacity of first class
	private int secondCapacity; //capacity of second class
	private int timeUntilNextArrival; //time until train arrives at next station
	private int timeSinceHuntington; //time since train arrived at huntington, negative indicates time until Huntington
	private int[] passengersBeforeArrival = new int[2]; //quantity of passengers before arrival at station
	private int[] passengersAfterArrival = new int[2]; //quantity of passengers after arrival at station
	private ArrayList<Passenger> embarking1; //list of passengers embarking at station
	private ArrayList<Passenger> embarking2; //list of passengers embarking at station
	private int number; //number of train
	private boolean arrived; //true if train is at a station
	private boolean full1;
	private boolean full2;
	private int stationIndex; //index of next station to be arrived at
	private boolean passedMineola; //true if the train has stopped at Mineola already
	
	public Train() {
	firstCapacity=0;
	secondCapacity=0;
	timeUntilNextArrival=1;
	embarking1 = new ArrayList<Passenger>(); embarking2 = new ArrayList<Passenger>();
	arrived=false;
	stationIndex = 3;
	passedMineola=false;
	passengersBeforeArrival[0]=0; passengersBeforeArrival[0]=0;
	passengersAfterArrival[1]=0; passengersAfterArrival[1]=0;
	full1 = false; full2 = false;
	}
	
	public void setStations(LinkedList<Station> stations) {
		this.stations=stations;
	}
	public void setFirstCapacity(int firstCapacity) {
		this.firstCapacity=firstCapacity;
	}
	public void setSecondCapacity(int secondCapacity) {
		this.secondCapacity=secondCapacity;
	}
	public void setTimeSinceHunt(int time) {
		this.timeSinceHuntington=time;
	}
	public boolean getPassedMineola() {
		return passedMineola;
	}
	
	public void simulateTimestep() {
		arrived=false;
		embarking1.clear();
		embarking2.clear();
	timeSinceHuntington++;
	
	if(timeSinceHuntington<0) {
		timeUntilNextArrival = -1 * timeSinceHuntington +1;
	}
	
	if(timeSinceHuntington%5==0 && timeSinceHuntington<=15 && timeSinceHuntington>=0) {
		arrived=true;
		timeUntilNextArrival=5;
		for(int i = 0; i < firstCapacity; i++) {
			if(!(stations.get(stationIndex).getFirstQueue().getQueue().isEmpty()) && !(full1)){
				embarking1.add(stations.get(stationIndex).getFirstQueue().dequeue());
				passengersAfterArrival[0]++;}}
		
		for(int i = 0; i < secondCapacity; i++) {
			if(!(stations.get(stationIndex).getSecondQueue().getQueue().isEmpty()) && !(full2)){
				embarking2.add(stations.get(stationIndex).getSecondQueue().dequeue());
				passengersAfterArrival[1]++;}}
	}
	else timeUntilNextArrival--;
	
	if(passengersAfterArrival[0] == firstCapacity) {
		full1=true;
	}
	if(passengersAfterArrival[1] == secondCapacity) {
		full2=true;
	}
	
	}
	
	
	public String toString() {
		
		String r ="\nTrain " + number;
		if(!arrived) {
			r+= " will arrive at " + stations.get(stationIndex).getName() + 
				" in " + timeUntilNextArrival + " minutes.";
		}
		
		else {
			r+= " arrives at " + stations.get(stationIndex).getName() +
					", there are ";
			
		//	if(embarking1.isEmpty()) {
			r+= passengersBeforeArrival[0];
			//else{
			//	r+= currentFirst-1 ;
			//}
			r += " passengers in first class and ";
			
			//if(embarking2.isEmpty()) {
			r+= passengersBeforeArrival[1];
				//else{
				//	r+= currentSecond-1 ;
				//}
			r += " in second class.";
			
			r+= "\nPassengers embarking in first class: ";
			if(embarking1.isEmpty()) {
				r+= "none";
			}
			else {
				for(int i = 0; i < embarking1.size(); i++) {
				r+="P" + embarking1.get(i).getId() + ", ";}
			}
			
			r+= "\nPassengers embarking in second class: ";
			if(embarking2.isEmpty()) {
				r+= "none";
			}
			else {
				for(int i = 0; i < embarking2.size(); i++) {
					r+="P" + embarking2.get(i).getId() + ", ";}
			}	
			
			passengersBeforeArrival[0] = passengersAfterArrival[0];
			passengersBeforeArrival[1] = passengersAfterArrival[1];
			passengersAfterArrival[0] = 0; passengersAfterArrival[1] = 0;

		}
		if(arrived) {
			stationIndex--;		
		}
		
		if(stationIndex==-1) {
			passedMineola=true;
		}
		return r;
	}
	
	public void setNumber(int number) {
		this.number=number;
	}
	
}
