/**
 * Jason Zhang
 * 500839581
 */

class Vehicle{
	// Instance Variables 
	private String mfr;
	private String color;
	private int power;
	private int numWheels;
	public static int ELECTRIC_MOTOR = 0;
	public static int GAS_ENGINE = 1;

	private int VIN;
/**
	* Creates a vehicle object
	* Constructor method
	* 
	* @param m a string value of manufacture name
	* @param c a string value of color
	* @param p a int value of engine type
*/
	public Vehicle(String m, String c, int p){
		mfr = m;
		color = c;
		power = p;
		numWheels = 4;
		VIN = (int) Math.floor(Math.random() *(499 - 100)) + 100;
	}
/**
    * returns the manufacture name  
	*
	* @return a string value of the manufacture name
*/
	public String getMfr(){
		return mfr;
	}

/**
  * returns the colour of the car 
  * 
  * @return a string value of the colour
*/
	public String getColor(){
		return color;
	}

/**
  * return the engine type 
  * 
  * @return the int value of the engine type 
*/	
	public int getPower(){
		return power;
	}

/**
  * return the number of wheels 
	* 
  * @return the integer value of the number of wheels
*/	
	public int getNumWheels(){
		return numWheels;
	}

/**
  * return the number of wheels 
	* 
  * @return the integer value of VIN
*/	
	public int getVIN()
	{
		return VIN;
	}

/**
  * set the manufacture name  
	*
	*@param m a string value of the manufacture 
*/
	public void setMfr(String m){
		mfr = m;
	}

/**
  * set the colour of the car
	*
  * @param c a string value of a colour 
*/
	public void setColor(String c){
		color = c;
	}

/**
  * set the power 
  * 
  * @param p a integer value of the power type of the car
*/	
	public void setPower(int p){
		power = p;
	}

/**
	* set the number of wheels
  * 
  * @param n integer value of the number of wheels
*/
	public void setNumWheels(int n){
		numWheels = n;
	}

	/**
	 * Test to see if vehicle is electric
	 * 
	 * @return a boolean value, True if power == ELECTRIC_MOTOR, else return false
	 */
	public boolean isElectric()
	{
		if(power == ELECTRIC_MOTOR)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}

/**
  * compares two Vehicle object and returns true if it is the objects are the same
	*
	* @param other The object that is being compared 
	* 
    * @return true if the Vehicle objects are the same or false if they are not 
*/
	public boolean equals(Object other){
        Vehicle otherV = (Vehicle) other;
		if(this.mfr.equals(otherV.getMfr()) && this.power == otherV.getPower() && this.numWheels == otherV.getNumWheels())
		{
			return true;		
		}
		else
		{
			return false;
		}
	}

/**
  * returns manufacture and colour of the car 
  * 
  * @return a string value of manufacture and colour
*/	
	public String display(){
		return getVIN() + " " + getMfr() + " " + getColor();
	}

}