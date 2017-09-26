package programmingiiiassignment2;
import org.joda.time.DateTime;
// Driver for Employee hierarchy
// Assignment 2 - Eamonn Hannon - 15310091
// Java core packages
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
// Java extension packages
import javax.swing.JOptionPane;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Test {
    public static void main(String args[]) {
        ArrayList<Employee> employees = new ArrayList<Employee>(5);
        //this array list is created and dates added to it
        //to create random dates to test with
        //unfortunately because DateTime throws on months out of range
        //they are not included in this random array and are tested for
        //manually
        ArrayList<DateTime> differentDates = new ArrayList<DateTime>(5);
        differentDates.add(new DateTime(1985, 6, 30, 13, 12));
        differentDates.add(new DateTime(2020, 8, 4, 10, 23 ));
        differentDates.add(new DateTime(1996, 2, 29, 9, 35));
        differentDates.add(new DateTime(2008, 10, 27, 8, 33));
        differentDates.add(new DateTime(2003, 1, 18, 11, 14));
        differentDates.add(new DateTime(2015, 7, 8, 12, 37));
        ArrayList<DateTime> randomDates = randomiseDates(differentDates, 3);
        Boss boss;
        try
        {
            boss = new Boss("John", "Smith", 800.0, randomDates.get(0));
            employees.add(boss);
        }
        catch(InvalidDateException ex)
        {
            System.err.println(ex.getMessage());
        }
        CommissionWorker commissionWorker;
        try
        {
            commissionWorker = new CommissionWorker(
                "Sue", "Jones", 400.0, 3.0, 150,
                2010, 13, 9, 14, 45);
            employees.add(commissionWorker);
        }
        catch(InvalidDateException ex)
        {
            System.err.println(ex.getMessage());
        }
        PieceWorker pieceWorker;
        try
        {
            pieceWorker = new PieceWorker("Bob", "Lewis", 2.5, 200,
                randomDates.get(1));
            employees.add( pieceWorker);
        }
        catch(InvalidDateException ex)
        {
            System.err.println(ex.getMessage());
        }
        HourlyWorker hourlyWorker;
        try
        {
            hourlyWorker  =
                new HourlyWorker("Karen", "Price", 13.75, 4,
                randomDates.get(2));
             employees.add(hourlyWorker);
        }
        catch(InvalidDateException ex)
        {
            System.err.println(ex.getMessage());
        }
        //this workwer will always exist so we put him in
        //as a test
        HourlyWorker willWorkWorker;
        try
        {
            willWorkWorker = new HourlyWorker("Bob", "Bobbington", 
                    13.75, 4, new DateTime(2014, 1, 1, 12, 0));
            employees.add(willWorkWorker);
        }
        catch(InvalidDateException ex)
        {
            System.err.println(ex.getMessage());
        }
        for(int i =0; i < 12; i++)
        {
           String finalOutput = monthlyUpdate(i+1, employees);
            JOptionPane.showMessageDialog(null, finalOutput,
                "Demonstrating Polymorphism",
                JOptionPane.INFORMATION_MESSAGE);
        }
        System.exit(0);
    }
    private static String monthlyUpdate(int month, ArrayList<Employee> employees)
    {
        DateTimeFormatter dateTimeFormat = DateTimeFormat.forPattern("dd/MM/yyyy");
        DateTime monthDate = new DateTime(2017, month, 1, 12, 0);
        DateTime endOfMonth = monthDate.dayOfMonth().withMaximumValue();
        String output = "Update for " + dateTimeFormat.print(endOfMonth) + "\n";
        DecimalFormat precision2 = new DecimalFormat("0.00");
        for(int i = 0; i < employees.size(); i++)
        {
            double earnings;
            try{
                earnings = employees.get(i).earnings();
                if(Days.daysBetween(employees.get(i).getStartDate(), endOfMonth).getDays() >= (365 * 5))
                {
                    earnings += 200.00;
                }
                output += employees.get(i).toString() + " earned € "
                    + precision2.format(earnings) + "\n";
            }
            catch(EarningsException en)
            {
                System.err.println(en.getMessage());
            }
        }
        return output;
    }
    private static ArrayList<DateTime> randomiseDates(ArrayList<DateTime> dates, int numDatesWanted)
    {
        ArrayList<DateTime> randomDates = new ArrayList<DateTime>();
        DateTime current = DateTime.now();
        //seed the random seed with the current time
        Random rand = new Random(current.getMillis());
        for(int i =0; i < numDatesWanted; i++)
        {
            int randInt = rand.nextInt(dates.size());
            randomDates.add(dates.get(randInt));
        }
        return randomDates;
    }
} // end class Test
