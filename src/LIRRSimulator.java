import java.util.LinkedList;
import java.util.Scanner;

public class LIRRSimulator {

	
	public static void main(String[] args) {
		
		
		LinkedList<Train> trains = new LinkedList<Train>();
		LinkedList<Station> stations = new LinkedList<Station>();
		Scanner in = new Scanner(System.in);
		int passengerIDs = 0; 
		
		System.out.println("Welcome to the LIRR Simulator, Leaving Irate Riders Regularly"); 
		System.out.println("\n\nMineola: ");
		stations.add(new Station());	
		stations.getLast().setName("Mineola");
		stations.getLast().setArrivalRates(in);
		System.out.println("\nHicksville: ");
		stations.add(new Station());	
		stations.getLast().setName("Hicksville");
		stations.getLast().setArrivalRates(in);
		System.out.println("\nSyosset: ");
		stations.add(new Station());	
		stations.getLast().setName("Syosset");
		stations.getLast().setArrivalRates(in);
		System.out.println("\nHuntington: ");
		stations.add(new Station());	
		stations.getLast().setName("Huntington");
		stations.getLast().setArrivalRates(in);
		
		boolean allTrainsPassedMin = false;
		
		System.out.println("\nPlease enter first class capacity: ");
		int firstCapacity = in.nextInt();
		System.out.println("\nPlease enter second class capacity: ");
		int secondCapacity = in.nextInt();
		System.out.println("\nPlease enter number of trains: ");
		int numTrains = in.nextInt();
		System.out.println("\nPlease enter last arrival time of passengers: ");
		int lastArrivalTime = in.nextInt();
		
		for(int i = 0; i < numTrains; i++) {
			trains.add(new Train());
			trains.get(i).setStations(stations);
			trains.get(i).setNumber(i+1);
			trains.get(i).setFirstCapacity(firstCapacity);
			trains.get(i).setSecondCapacity(secondCapacity);
			trains.get(i).setTimeSinceHunt(-1-(5*i));
		}
		
		
		System.out.println("\nBegin Simulation:\n---------------------------------------------");
		
		int steps = -1;
		do {
			steps++;	
			System.out.println("\nTime " + steps + ":");	
			System.out.println("\nStation Overview:");
			
			for(int i = 0; i < 4; i++) {
				stations.get(i).simulateTimestep();
				if(stations.get(i).getNewArrivals()[0]) {
						passengerIDs++;
					stations.get(i).getFirstQueue().getQueue().getLast().setId(passengerIDs);
				}
				if(stations.get(i).getNewArrivals()[1]) {
					passengerIDs++;
					stations.get(i).getSecondQueue().getQueue().getLast().setId(passengerIDs);
				}
			}
			
			
			for(int i =0; i < 4; i++) {
				System.out.println(stations.get(i).toString());
			}
				
			for(int i = 0; i < numTrains; i++) {
				//if(steps>=5*i)
				trains.get(i).simulateTimestep();
			}
			for(int i = 0; i < numTrains; i++) {
				System.out.println(trains.get(i).toString());
			}	
				
			
			allTrainsPassedMin=true;	
			for(int i = 0 ; i < trains.size(); i++) {
				if(!(trains.get(i).getPassedMineola())) {
					allTrainsPassedMin=false;
				}
			}
			System.out.println("\n-------");
		} while(!allTrainsPassedMin);
		
		
	}
}
