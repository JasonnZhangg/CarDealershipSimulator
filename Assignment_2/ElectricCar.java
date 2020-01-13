class ElectricCar extends Car
{
    //Instance Variables
    private int rechargeTime;
    private String batteryType;

    /**
	* Creates a ElectricCar object
	* Constructor method
	* 
	* @param m a string value of manufacture name
	* @param c a string value of color
	* @param p a int value of engine type
    * @param n a int value of number of wheels
    * @param model a string value of model
    * @param int a int value of max
    * @param safety a double value of safety value
    * @param all a boolean value for AWD
    * @param price a int value of price of car
    * @param rt a int value of minutes to recharge car
    * @param bt a string value of battery type
*/   
    public ElectricCar(String m, String c, int p, int n, int model, int max, 
    double safety, boolean all, int price, int rt)
    {
        super(m,c,0,n,model,max,safety,all,price);
        this.rechargeTime = rt;
        this.batteryType = "Lithium";
    }

/**
    * set battery type
    * 
    * @param bt an String value of Battery type
*/      
    public void setBatteryType(String bt)
    {
        this.batteryType = bt;
    }

/**
    * set recharge time
    * 
    * @param rt an int value of the recharge time
*/   
    public void setRechargeTime(int rt)
    {
        this.rechargeTime = rt;
    }

/**
    * return battery type
    * 
    * @return a String value of battery type
*/ 
    public String getBatteryType()
    {
        return batteryType;
    }

/**
    * return recharge time
    * 
    * @return a int value of recharge time
*/    
    public int getRechargeType()
    {
        return rechargeTime;
    }

/**
    * returns manufacture, colour, price, safety rating, and max range, recharge time, battery type 
    * 
    * @return a string value super.display(), rechargeTime, batteryType
    * @see Car
    *
    * @Overrides
*/    
    public String display()
    {
        return super.display() + " Recharge Time: " + rechargeTime + " Battery Type: " + batteryType;
    }
} //End of ElectricCar