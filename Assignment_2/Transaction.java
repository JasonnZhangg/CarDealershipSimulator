/**
 * Jason Zhang
 * 500839581
 */

import java.text.SimpleDateFormat;
import java.util.*;

class Transaction
{
    //Instance Variable
    private int transactionId;
    private Calendar transactionDate;
    private Car boughtCar;
    private String saleName;
    private String transactionType;
    private double transactionPrice;

    /**
	* Creates a Transaction object
	* Constructor method
	* 
	* @param ti a int value of Transaction ID
	* @param td a Calendar object of transactionDate
	* @param bc a Car object
	* @param sn a String value name of sales person involved in Transaction
    * @param tt a String of transactionType
    * @param tp a double value of transactionPrice
    */
    public Transaction(int ti, Calendar td, Car bc, String sn, String tt, double tp)
    {
        transactionId = ti;
        transactionDate = td;
        boughtCar = bc;
        saleName = sn;
        transactionType = tt;
        transactionPrice = tp;
    }

    /**
    * returns transaction details
    * 
    * @return a string value of Transaction variables
    */	
    public String display()
    {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd");

    return "Transaction Id: " + transactionId +  " Date: " + sdf.format(transactionDate.getTime())
    + "\nCar: " + boughtCar.display() + "\nSale Person: " + saleName + " Transaction type: " + transactionType + " Transaction Price: " + transactionPrice;
    }

    /**
     * returns the transaction price
     * 
     * @return a double value of the transactionPrice
     */
    public double getTransactionPrice()
    {
        return transactionPrice;
    }

    /**
     * 
     * @return a string value of transactionType
     */
    public String getTransactionType()
    {
        return transactionType;
    }

    /**
     * Returns the sale person's name
     * 
     * @return a string value of saleName
     */
    public String getSalePerson()
    {
        return saleName;
    }

    /**
     * Returns the transaction ID
     * 
     * @return a int value of transaction ID
     */
    public int getID()
    {
        return transactionId;
    }

    /**
     * Returns the Transaction date
     * 
     * @return Calendar object
     */
    public Calendar getCalendar()
    {
        return transactionDate;
    }

    /**
     * return the car
     * 
     * @return a Car Object
     */
    public Car getCar()
    {
        return boughtCar;
    }

}