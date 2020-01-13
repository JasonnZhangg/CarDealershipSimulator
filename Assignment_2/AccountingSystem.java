/**
 * Jason Zhang
 * 500839581
 */

import java.util.ArrayList;
import java.util.*;
import java.text.SimpleDateFormat;

class AccountingSystem
{
    //Instance Variables
    private ArrayList<Transaction> transList;

    public AccountingSystem()
    {
        transList = new ArrayList<Transaction>();
    }
    /**
     * Creates a transaction and then adds it into the list of transactions
     * 
     * @param date a Calendar object date of transaction
     * @param car a Car object car involved in transaction
     * @param salesPerson a string value of the sales person in transaction
     * @param type a String value of the type of transaction
     * @param salePrice a double value of the Sale Price
     * @return a String Value of all the details of the transaction
     */
    public String add(Calendar date, Car car, String salesPerson, String type, double salePrice)
    {
        int id =(int) Math.floor(Math.random() *100);
        Transaction trans = new Transaction(id, date, car, salesPerson, type, salePrice);
        transList.add(trans);
        return trans.display();
    }

    /**
     * return the month with the most of cars sold
     * 
     * @return a String value of the month with the most of cars sold
     */
    public String carsMonth()
    {
        int[] months = new int[12];
        for(int i = 0; i < 12; i++)
        {
            months[i] = 0;
        }
        for(int i = 0; i < transList.size(); i++)
        {
            if(transList.get(i).getTransactionType().equals("BUY"))
            {
                months[transList.get(i).getCalendar().get((Calendar.MONTH))] = months[transList.get(i).getCalendar().get((Calendar.MONTH))]++;  
            }
        }//End for transList for
        int biggest = 0;
        int index = 0;
        for (int i = 0; i < months.length; i++) 
        { 
            if(biggest < months[i])
            {
                biggest = months[i];
                index = i;
            }
        }
        switch(index)
        {
            case(0):
                return "January";

            case(1):
                return "February";

            case(2):
                return "March";

            case(3):
                return "April";

            case(4):
                return "May";

            case(5):
                return "June";

            case(6):
                return "July";

            case(7):
                return "August";

            case(8):
                return "September";
            case(9):
                return "October";
            case(10):
                return "November";
            case(11):
                return "December";
            default:
                return null;
        }
    }

     /**
     * return the number of cars returned
     * 
     * @return a int value of the total number of cars returned
     */
    public int carsReturn()
    {
        int totalReturn = 0;
        for(int i = 0; i < transList.size(); i++)
        {
            if(transList.get(i).getTransactionType().equals("RETURN"))
            {
                totalReturn++;
            }
        }
        return totalReturn;
    }

    /**
     * return the number of cars Sold
     * 
     * @return a int value of the total number of cars Sold
     */
    public int carsSold()
    {
        int totalSold = 0;
        for(int i = 0; i < transList.size(); i++)
        {
            if(transList.get(i).getTransactionType().equals("BUY"))
            {
                totalSold++;
            }
        }
        return totalSold;
    }

    /**
     * return the value of all sales
     * 
     * @return a double value of the total of all the sales
     */
    public double totalSale()
    {
        double totalSale = 0;
        for(int i = 0; i < transList.size(); i++)
        {
            if(transList.get(i).getTransactionType().equals("BUY"))
            {
                totalSale = totalSale + transList.get(i).getTransactionPrice();
            }
        }
        return totalSale;
    }

    /**
     * Find all transactions within month and returning it
     * 
     * @param m an integer value of month 
     * 
     * @return a String value of all transactions that took place within the month
     */
    public String monthTrans(int m)
    {
       String monthTransactions = "";
       for(int i = 0; i < transList.size(); i++)
        {
            int date = transList.get(i).getCalendar().get(Calendar.MONTH);
            if(date == m)
            {
                monthTransactions = monthTransactions + transList.get(i).display() + "\n";
            }
        }
        return monthTransactions;

    }
    
    /**
     * Finds the sale person with the most sales and returns their names and cars sold
     * 
     * @return String value with all the sale people with top sales
     */
    public String topSales()
    {
        String result = "";
        Map<String, Integer> sales = new TreeMap<String, Integer>();
        for(int i = 0; i < transList.size(); i++)
        {
            sales.put(transList.get(i).getSalePerson(),0);
        }
        for(int i = 0; i < transList.size(); i++)
        {

            if(transList.get(i).getTransactionType().equals("BUY"))
            {
                int n = sales.get(transList.get(i).getSalePerson());
                sales.put(transList.get(i).getSalePerson(),n+1);
            }
        }
        Set<String> keySet = sales.keySet();
        ArrayList<String> biggest = new ArrayList<String>();
        int big = 0;
        for (String key :keySet)
        {
            if(sales.get(key) == big)
            biggest.add(key);
            else if(sales.get(key) > big)
            {
                big = sales.get(key);
                biggest.clear();
                biggest.add(key);
            }
        }
        for(int i = 0; i < biggest.size(); i++)
        {
            result  =  biggest.get(i) + " " + big + " cars sold " + result;
        }
        return result;
    }

    /**
     * Get the transaction
     * 
     * @param id an int value of the transaction ID
     * @return transaction object
     */
    public Transaction getTransaction(int id)
    {
        for(int i = 0; i < transList.size(); i++)
        {
            if(transList.get(i).getID() == id)
            {
                return transList.get(i);
            }
            
        }
        return null;
    }

    public String allTransactions()
    {
        String result = "";
        for(int i = 0; i < transList.size(); i++)
        {
            result = result + transList.get(i).display() + "\n";
        }
        return result;
    }
}