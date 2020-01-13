/**
 * Jason Zhang
 * 500839581
 */

import java.util.Comparator;
import java.lang.Comparable;

class Car extends Vehicle implements Comparable<Car>{
    // Instance Variables 
	private int model;
	private int maxRange;
	private double safetyRating;
	private boolean AWD;
	private double price;
	public static final int SEDAN = 0;
    public static final int SUV = 1;
    public static final int SPORTS = 2;
    public static final int MINIVAN = 3;


 /**
	* Creates a vehicle object
	* Constructor method
	* 
	* @param m a string value of manufacture name
	* @param c a string value of color
	* @param p a int value of engine type
    * @param model a string value of model
    * @param int a int value of max
    * @param safety a double value of safety value
    * @param all a boolean value for AWD
    * @param price a int value of price of car
*/   
	public Car(String m, String c, int p, int model, int max, 
	double safety, boolean all, int price){
		super(m,c,p);
		this.model = model;
		this.maxRange = max;
		this.safetyRating = safety;
		this.AWD = all;
		this.price = price;
	}


/**
    * returns string value of manufacture, color, model, price,
    * safety rating, and max range
    * 
    * @return a string value of super.display(), model, price, safetyRating, and maxRange
    * @see Vehicle
    *
    * @Overrides
*/    

	public String display(){
        String displayModel = "";
        if(model == SEDAN){
            displayModel = "Sedan";
        }
        else if(model == SUV)
        {
            displayModel = "SUV";
        }
        else if(model == SPORTS)
        {
            displayModel = "Sports Car";
        }
        else if(model == MINIVAN)
        {
            displayModel = "Minivan";
        }

		return super.display() + " Model: " + displayModel + " Max Range: " + maxRange
		+ " safety Rating : " + safetyRating + " AWD: " + AWD + " Price: " + price; 
	}

/**
	 * Test to see if vehicle is AWD
	 * 
	 * @return AWD, a boolean value
	 */
	public boolean isAWD()
	{
        return AWD;
    }
    
    /**
     * return the price of Car
     * 
     * @return price, a double value 
     */
    public double getPrice()
    {
        return price;
    }

/**
    * compares two car objects to check if mfg, power, number of wheels, model, and AWD are equal
    * return true if the two Cars are the same else false
    * 
    * @param other an object that can be casted into a Car object
    *
    * @return boolean value
    * @see Vehicle
    *
    * @Overrides 
*/
	public boolean equals(Object other)
	{
        Car otherC = (Car)other;
        if(super.equals(otherC) && this.model == otherC.model && this.AWD == otherC.AWD)
        {
            return true;
        }
        else
        {
            return false;
        }
    } 

/**
     * overrides the Comparable interface and compares the prices of two Cars and returns an integer value
     * 
     * @param other a Car object
     * @return an integer value 
     *
*/    
	public int compareTo(Car other)
	{
        if(this.price > other.price)
        {
            return 1;
        }
        else if(this.price < other.price)
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }
    
    //Inner Clas for sortBySafetyRating
    //implements comparator
    public static class sortBySafetyRating implements Comparator<Car>
    {
    /**
        * overrides the Comparator interface and compares the safety rating of two Cars and returns an integer value 
        *
        * @param a a Car object
        * @param b a Car object
        * @return an integer value
        *
    */   
        public int compare(Car a, Car b)
        {
            if(a.safetyRating > b.safetyRating)
        {
            return 1;
        }
        else if(a.safetyRating < b.safetyRating)
        {
            return -1;
        }
        else
        {
            return 0;
        }
        }
    }

    //Inner Class for sortByRange
    //implements comparator
    public static class sortByRange implements Comparator<Car>
    {
        /**
        * overrides the Comparator interface and compares the range of two Cars and returns an integer value 
        *
        * @param a a Car object
        * @param b a Car object
        * @return an integer value
        *
    */ 
        public int compare(Car a, Car b)
        {
            if(a.maxRange > b.maxRange)
        {
            return 1;
        }
        else if(a.maxRange < b.maxRange)
        {
            return -1;
        }
        else
        {
            return 0;
        }
        }
    }
}	  