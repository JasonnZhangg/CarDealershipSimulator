/**
 * Jason Zhang
 * 500839581
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

import javax.lang.model.util.ElementScanner6;

public class CarDealershipSimulator 
{
  public static void main(String[] args)
  {
	// Create a CarDealership object
	CarDealership carDealer = new CarDealership();	  
	// Then create an (initially empty) array list of type Car
	ArrayList<Car> carList = new ArrayList<Car>();
	Car boughtCar = null;
	
	// Try method
	try
    {
		//File Scanner
        File inputFile = new File("cars.txt");
		Scanner inFile = new Scanner(inputFile);
		
		//Variables for car
        String manufacutre = "";
        String color = "";
        int power = 0;
        int model = 0;
        double safety = 0;
        boolean allWheel = false;
        int count = 0;
        int max = 0;
        int  price = 0;

        while(inFile.hasNext())
        {
            if(count % 8==0)
            {
                manufacutre = inFile.next();
            }
            else if(count % 8 ==1)
            {
                color = inFile.next();
            }
            else if(count % 8 == 2)
            {
                switch (inFile.next())
                {
                    case "SEDAN":
                        model = 0;
                        break;
                    case "SUV":
                        model = 1;
                        break;
                    case "SPORTS":
                        model = 2;
                        break;
                    case "MINIVAN":
                        model = 3;
                        break;
                }
            }
            else if(count % 8 == 3)
            {
                switch(inFile.next())
                {
                    case "GAS_ENGINE":
                        power = 1;
                        break;
                    case "ELECTRIC_MOTOR":
                        power = 2;
                }
            }
            else if(count % 8 == 4)
            {    
                safety = inFile.nextDouble();
            }
            else if(count % 8 == 5)
            {
                max = inFile.nextInt();
            }
            else if(count % 8 == 6)
            {
                    switch(inFile.next())
                {
                    case "2WD":
                        allWheel = false;
                        break;
                    case "AWD":
                        allWheel = true;
                        break;
                }
            }
            else if(count % 8 == 7)
            {
                price = inFile.nextInt();
                carList.add(new Car(manufacutre, color, power, model, max, safety, allWheel, price));
            }
            count++;     
            
        }
	}
    catch(FileNotFoundException exception)
    {
        System.out.println("File Not Found");
    }

	  // Create a scanner object
		Scanner in = new Scanner(System.in);
		// while the scanner has another line
		String [] line = new String[3];
		line = in.nextLine().split(" ");
			  //    read the input line
	  //    create another scanner object (call it "commandLine" or something) using the input line instead of System.in
	  //    read the next word from the commandLine scanner 
      //	check if the word (i.e. string) is equal to one of the commands and if so, call the appropriate method via the CarDealership object  
		while(!line[0].toLowerCase().equals("q"))
		{
			if(line[0].toLowerCase().equals("l"))
			{
				carDealer.displayInventory();
			}
			else if(line[0].toLowerCase().equals("add"))
			{
				carDealer.addCars(carList);	
			}
			else if(line[0].toLowerCase().equals("buy"))
			{
				try
				{
					System.out.println(carDealer.buyCar(Integer.parseInt(line[1])));
				}
				catch(IllegalArgumentException exception)
				{
					System.out.println("Please try again");
				}

			}
			else if(line[0].toLowerCase().equals("ret"))
			{
				try
				{
					carDealer.returnCar(Integer.parseInt(line[1]));
				}
				catch(IllegalArgumentException exception)
				{
					System.out.println("Please try again");
				}
				catch(NullPointerException exception)
				{
					System.out.println("Not Valid TransactionID");
				}
			}
			else if(line[0].toLowerCase().equals("spr"))
			{
				carDealer.sortByPrice();
			}
			else if(line[0].toLowerCase().equals("ssr"))
			{
				carDealer.sortBySafetyRating();
			}
			else if(line[0].toLowerCase().equals("smr"))
			{
				carDealer.sortByRange();
			}
			else if(line[0].toLowerCase().equals("fpr"))
			{
				carDealer.filterByPrice(Double.parseDouble(line[1]), Double.parseDouble(line[2]));
			}
			else if(line[0].toLowerCase().equals("fel"))
			{
				carDealer.filterByElectric();
			}
			else if(line[0].toLowerCase().equals("faw"))
			{
				carDealer.filterByAWD();
			}
			else if(line[0].toLowerCase().equals("fcl"))
			{
				carDealer.filtersClear();	
			}
			else if(line[0].toLowerCase().equals("sales"))
			{
				try
				{
					//Test if s is a valid integer
				   Integer.parseInt(line[1]);
				   if(Integer.parseInt(line[1]) >= 0 && Integer.parseInt(line[1]) < 12)
				   {
					   carDealer.displayMonthTrans(Integer.parseInt(line[1]));
				   }
				   else
				   {
					   System.out.println("Incorrect command");
				   }
				}
				catch(NumberFormatException ex)
				{
						if(line[1].toLowerCase().equals("team"))
						{
							carDealer.displayAllSaleTeam();
						}
						else if(line[1].toLowerCase().equals("topsp"))
						{
							carDealer.displayTopSale();
						}
						else if(line[1].toLowerCase().equals("stats"))
						{
							carDealer.displayStats();
						}
						else
						{
							System.out.println("Incorrect Command");
						}
				}//NumberFormatException Catch
				catch(ArrayIndexOutOfBoundsException exception)
				{
						carDealer.displayAllTransaction();
				}//ArrayIndexOutOfBoundsException catch
			}
			else
			{
				System.out.println("Not a correct command");
			}
			line = in.nextLine().split(" ");
		}
		
  }
}






