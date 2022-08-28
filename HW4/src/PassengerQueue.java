import java.util.LinkedList;

public class PassengerQueue {

	private LinkedList<Passenger> queue;
	
	public PassengerQueue()
	{
		queue = new LinkedList<Passenger>();
	}
	
	public void enqueue(Passenger p) {
		queue.add(p);
	}
	public Passenger dequeue() {
		return queue.remove(0);
	}
	public String toString() {
		String r = "";
		if(queue.get(0).isFirstClass) {
		r += "\nFirst [";}
		else {
			r += "\nSecond [";}
		
		for(int i = 0; i < queue.size(); i++) {
			if(queue.size()==1) {
				r += "P" + queue.get(i).getId() + "@T" + queue.get(i).getArrivalTime(); }
			else if(queue.get(i).equals(queue.get(queue.size()-1))) {
				r += "P" + queue.get(i).getId() + "@T" + queue.get(i).getArrivalTime();
				}
			else {
				r += "P" + queue.get(i).getId() + "@T" + queue.get(i).getArrivalTime()+ ", ";
				}
		}
			
		return r;
	}
	
	public LinkedList<Passenger> getQueue(){
		return queue;
	}
}