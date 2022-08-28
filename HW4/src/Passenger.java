/**
 * 
 * @author Faiz
 *
 */
public class Passenger {

	int id;
	int arrivalTime;
	boolean isFirstClass;
	
	/**
	 * Constructs a Passenger object
	 */
	public Passenger() {
	}
	/**
	 * Returns the ID data field
	 * 
	 * @return
	 * 	Returns the ID data field
	 */
	public int getId() {
		return id;
	}
	/**
	 * Returns the arrivalTime data field
	 * 
	 * @return
	 * 	Returns the arrivalTime data field
	 */
	public int getArrivalTime() {
		return arrivalTime;
	}
	/**
	 * Returns the isFirstClass data field
	 * 
	 * @return
	 * 	Returns the isFirstClass data field
	 */
	public boolean getIsFirstClass() {
		return isFirstClass;
	}
	/**
	 * Sets the id data field to a specified int
	 * 
	 * @param id
	 * 	int to set as id
	 */
	public void setId(int id) {
		this.id=id;
	}
	/**
	 * Sets the arrivalTime data field to a specified int
	 * 
	 * @param arrivalTime
	 * 	int to set as arrivalTime
	 */
	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime=arrivalTime;
	}
	/**
	 * Sets the isFirstClass data field to true or false
	 * 
	 * @param isFirstClass
	 * 	boolean value to set as isFirstClass
	 */
	public void setIsFirstClass(boolean isFirstClass) {
		this.isFirstClass=isFirstClass;
	}
}

	