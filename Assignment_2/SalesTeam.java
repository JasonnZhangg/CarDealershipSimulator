/**
 * Jason Zhang
 * 500839581
 */

import java.util.LinkedList;
import java.util.*;


class SalesTeam
{
    //Instance Variable
    LinkedList<String> salesList;

    /**
     * Constructor Method, with 5 names
     * 
     *  */    

    public SalesTeam()
    {
        salesList = new LinkedList<String>();
        salesList.add("Julie");
        salesList.add("James");
        salesList.add("William");
        salesList.add("Chloe");
        salesList.add("Jenna");
    }

    /**
     * Returns a random sales person
     * 
     * @return a String value of the name of the Sales person from salesList
     */
    public String getSalePerson()
    {
        int x = (int) Math.floor(Math.random() *salesList.size());
        return salesList.get(x);
    }

    /**
     * Returns all the names on salesList
     * 
     * @return a String value of all the names on saleList
     */
    public String displayAll()
    {
        String result = "";
        ListIterator<String> iter = salesList.listIterator();

        while(iter.hasNext())
        {
            String name = iter.next();
            result = name + " " + result;
        }
        return result;
    }

    /**
     * total number of sales people on the team
     * 
     * @return a int value of the total size of salesList
     */
    public int getTotalTeam()
    {
        return salesList.size() + 1;
    }


}