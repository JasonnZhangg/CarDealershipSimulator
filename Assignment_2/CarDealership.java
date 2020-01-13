/**
 * Jason Zhang
 * 500839581
 */

import java.util.*;
import java.lang.*;

class CarDealership
{
    //Instance Variables
    ArrayList <Car> cars;
    private boolean filterByElectric;
    private boolean filterByAWD;
    private double maxPrice;
    private double minPrice;
    private boolean filterByPrice;
    private ArrayList<Car> filteredList;
    private SalesTeam team; 
    private AccountingSystem accounting;
    
    /**
     * Create ArrayList of car objects
     * Constructor method
     */
    public CarDealership()
    {
        cars = new ArrayList<Car>();
        filterByElectric = false;
        filterByAWD = false;
        maxPrice = 0;
        minPrice = 0;
        filterByPrice = false;
        filteredList = new ArrayList<Car>();
        accounting = new AccountingSystem();
        team = new SalesTeam();
    }// End CarDealership constructor method

    public void displayStats(){
        System.out.println("Total Sales: " + accounting.totalSale() + "\nAverage per Month: " + accounting.totalSale()/12 + "\nTotal Cars Sold: " 
        + accounting.carsSold() + "\nBest Month: " + accounting.carsMonth()+  "\nTotal Car Returns:" + accounting.carsReturn());
    }

    /**
     * Prints all the transactions within that month
     * 
     * @param month an Integer value month being looked for
     */
    public void displayMonthTrans(int month)
    {
        System.out.println(accounting.monthTrans(month));
    }

    /**
     * Prints the sales people with the most sales
     */
    public void displayTopSale()
    {
        System.out.println(accounting.topSales());
    }

    /**
     * Prints the entire sales team
     */
    public void displayAllSaleTeam()
    {
        System.out.println(team.displayAll());
    }

    /**
     * Prints all transactions in accounting
     */
    public void displayAllTransaction()
    {
        System.out.println(accounting.allTransactions());
    }

    public String buyCar(int VIN) 
    {
        Car indexedCar;
        String salePerson;
        Calendar calendar;
            if(!filteredList.isEmpty())
            {
                for(int i =0; i < filteredList.size(); i++)
                {
                    if(filteredList.get(i).getVIN() == VIN)
                    {
                        indexedCar = filteredList.get(i);
                        filteredList.remove(i);
                        cars.remove(indexedCar);
                        salePerson = team.getSalePerson();
                        int m = (int)Math.floor(Math.random() *12)+1; 
                        int d =(int) Math.floor(Math.random() *30)+1;
                        if(m % 2 == 0)
                        {
                           d = (int)Math.floor(Math.random() *31)+1; 
                        }
                        else
                        {
                            d =(int) Math.floor(Math.random() *30)+1;
                        }
                        calendar = new GregorianCalendar(2019,m,d);
                        return accounting.add(calendar, indexedCar, salePerson, "BUY", indexedCar.getPrice());
                    }
                }
                    return null;
            }
            else
            {
                for(int i =0; i < cars.size(); i++)
                {
                    if(cars.get(i).getVIN() == VIN)
                    {
                        indexedCar = cars.get(i);
                        cars.remove(i);
                        salePerson = team.getSalePerson();
                        int m = (int) Math.floor(Math.random() *12)+1;
                        int d =(int) Math.floor(Math.random() *30)+1; 
                        if(m % 2 == 0)
                        {
                            d = (int)Math.floor(Math.random() *31)+1; 
                        }
                        else
                        {
                            d =(int) Math.floor(Math.random() *30)+1;
                        }
                        calendar = new GregorianCalendar(2019,m,d);
                        return accounting.add(calendar, indexedCar, salePerson, "BUY", indexedCar.getPrice());
                    }
                }
                return null;
            } 
    }

    public void returnCar(int transaction)
    {
        Car retCar;
        String salePerson;
        Calendar calendar;
        Transaction retTrans = accounting.getTransaction(transaction);
        int m = retTrans.getCalendar().get(Calendar.MONTH);
        int d = retTrans.getCalendar().get(Calendar.DAY_OF_MONTH);
        int nd =(int) Math.floor(Math.random() *(30-d))+d+1;
        if(m % 2 == 0)
        {
            nd =(int) Math.floor(Math.random() *(31-d))+d+1; 
        }
            else
        {
            nd =(int) Math.floor(Math.random() *(30-d))+d+1;
        }
        calendar = new GregorianCalendar(2019,m,nd);
        retCar = retTrans.getCar();
        salePerson = retTrans.getSalePerson();
        cars.add(retCar);
        filteredList.clear();
        accounting.add(calendar, retCar, salePerson, "RETURN", retCar.getPrice());
    }

    /**
     * Takes in Array list of cars called newCars and adds it into cars array list
     * 
     * @param newCars an ArrayList<car> of new cars 
     */
    public void addCars(ArrayList<Car> newCars)
    {
        for(int i = 0; i < newCars.size(); i++)
        {
            Car tempCar = newCars.get(i);
            cars.add(tempCar);
        }
    }//End of addCars method

    /**
     * A car based on the index entered will be removed from the cars arrayList
     * The car removed will be returned. If index is not valid, method will return null
     * 
     * @param index integer value of the index of the Car
     * @return the Car object of the bought car
     */
    /*public Car buyCar(int index)
    {
        Car indexedCar;
        if(index >= cars.size() || index < 0)
        {
            return null;
        }
        else if(index >= filteredList.size() && !filteredList.isEmpty())
        {
            return null;
        }
        if(!filteredList.isEmpty())
        {
            indexedCar = filteredList.get(index);
            filteredList.remove(index);
            cars.remove(indexedCar);
            return indexedCar;
        }
        else
        {
            indexedCar = cars.get(index);
            cars.remove(index);
            return indexedCar;
        }
    }//End of buyCar method
*/
    /**
     * Adds a car object back into cars ArrayList 
     * Checks if object is not null
     * 
     * @param object car object of car being added back into ArrayList
     */
    /*
     public void returnCar(Car car)
    {
        if(car != null)
        {
            cars.add(car);
            filteredList.clear();
        }
        
    }
    */
    /**
     * set filterByElectric to true
     */
    public void filterByElectric(){
        filterByElectric = true;
    }

    /**
     * set filterByAWD to true
     */
    public void filterByAWD(){
        filterByAWD = true;
    }

    /**
     * set filterByPrice to true and sets max and min price for filter
     */
    public void filterByPrice(double num, double num1){
        filterByPrice = true;
        this.maxPrice = Math.max(num, num1);
        this.minPrice = Math.min(num, num1);
    }

    /**
     * clear all filters
     */
    public void filtersClear(){
        filterByElectric = false;
        filterByAWD = false;
        maxPrice = 0;
        minPrice = 0;
        filterByPrice = false;
        filteredList.clear();
    }

    /**
     * if cars is not filtered then sort cars arrayList by price,
     * else sort filtered list by price
     * Uses collections.sort and comperable interface
     */
    public void sortByPrice()
    {
        if (!cars.isEmpty() && filteredList.isEmpty()){
            Collections.sort(cars);
        }else if (!filteredList.isEmpty()){
            Collections.sort(filteredList);
        }
    }

    /**
     * if cars is not filtered then sort cars arrayList by safety price,
     * else sort filtered list by price
     * Uses collections.sort and comparator interface
     */
    public void sortBySafetyRating()
    {
        if (!cars.isEmpty() && filteredList.isEmpty()){
            Collections.sort(cars, new Car.sortBySafetyRating());
        }else if (!filteredList.isEmpty()){
            Collections.sort(filteredList, new Car.sortBySafetyRating());
        }
    }

    /**
     * if cars is not filtered then sort cars arrayList by max range,
     * else sort filtered list by max range
     * Uses collections.sort and comparator interface
     */
    public void sortByRange()
    {
        if (!cars.isEmpty() && filteredList.isEmpty()){
            Collections.sort(cars, new Car.sortByRange());
        }else if (!filteredList.isEmpty()){
            Collections.sort(filteredList, new Car.sortByRange());
        }
    }

    /**
     * Checks for any filters active and then filter cars according to filter set
     * Checks if cars are filtered and then prints out the list of cars in Cars ArrayList or filteredList ArrayList
     */
    public void displayInventory()
    {
        /**
        * Filter out cars that are not electric
        * If cars not already filtered, then run through cars arraylist and add any electric cars into filteredList
        * If cars already filtered, then remove any not electric cars from filteredList
        */
        if(filterByElectric)
        {
            if(filteredList.isEmpty())
        {
            for(int i = 0; i < cars.size(); i++)
            {
                if(cars.get(i).isElectric())
                {
                    filteredList.add(cars.get(i));
                }
            }
        }
        else
        {
            for(int i = 0; i < filteredList.size(); i++)
            {
                if(filteredList.get(i).isElectric() == false)
                {
                    filteredList.remove(filteredList.get(i));
                }
            }
        }
        }
        /**
        * Filter out cars that are not AWD
        * If cars not already filtered, then run through cars arraylist and add any AWD cars into filteredList
        * If cars already filtered, then remove any not AWD cars from filteredList
        */
        if(filterByAWD)
        {
            if(filteredList.isEmpty())
        {
            for(int i = 0; i < cars.size(); i++)
            {
                if(cars.get(i).isAWD())
                {
                    filteredList.add(cars.get(i));
                }
            }
        }
        else
        {
            for(int i = 0; i < filteredList.size(); i++)
            {
                if(filteredList.get(i).isAWD() == false)
                {
                    filteredList.remove(filteredList.get(i));
                }
            }
        }
        }
        /**
        * Filter out cars that are not with in the price range
        * If cars not already filtered, then run through cars arraylist and add any AWD cars into filteredList
        * If cars already filtered, then remove any not in price range cars from filteredList 
        */
        if(filterByPrice)
        {
            if(filteredList.isEmpty())
            {
                for(int i = 0; i < cars.size(); i++)
                {
                    if(cars.get(i).getPrice() >= minPrice && cars.get(i).getPrice() <= maxPrice)
                    {
                        filteredList.add(cars.get(i));
                    }
                }
            }
            else
            {
                for(int i = 0; i < filteredList.size(); i++)
                {  
                    if(cars.get(i).getPrice() < minPrice || cars.get(i).getPrice() > maxPrice)
                    {
                        filteredList.remove(filteredList.get(i));
                    }
                }
            }
        }

        if(filteredList.isEmpty())
        {
            for(int i = 0; i < cars.size(); i++)
            {
                System.out.println(i + " " + cars.get(i).display());
            }
        }
        else{
            for(int i = 0; i < filteredList.size(); i++)
            {
                System.out.println(i + " " + filteredList.get(i).display());
            }
        }
    }

}// End of class CarDealership