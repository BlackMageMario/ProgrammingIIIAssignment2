package programmingiiiassignment2;
// Abstract base class Employee.

import org.joda.time.DateTime;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


public abstract class Employee {

    private String firstName;
    private String lastName;
    private int currentEmployNum;
    private DateTime startDate;
    private static int employeeNum = 0;
    private DateTimeFormatter dateTimeFormat = DateTimeFormat.forPattern("dd/MM/yyyy");

    // constructor
    public Employee(String first, String last, DateTime date) 
            throws InvalidDateException{
        firstName = first;
        lastName = last;
        testDate(date);
        startDate = date;
        currentEmployNum = employeeNum++;
    }
    //second constructor handle dates entered in manually
    public Employee(String first, String last, int year, int month, 
            int day, int hour, int minute)throws InvalidDateException
    {
        firstName = first;
        lastName = last;
        DateTime dateToTest;
        try
        {
             dateToTest = new DateTime(year, month, day, hour, minute);
        }
        catch(IllegalFieldValueException ex)
        {
            //catch joda time exception and throw new one
            String fullName = firstName + " " + lastName;
            String dateString = day + "/" + month + "/" + year;
            throw new InvalidDateException(fullName, dateString, "the month supplied is out of range [1, 12].");
        }
        testDate(dateToTest);
        startDate = dateToTest;
        currentEmployNum = employeeNum++;
    }

    // get first name
    public String getFirstName() {
        return firstName;
    }
    private void testDate(DateTime date) throws InvalidDateException
    {
        String fullName = firstName + " " + lastName;
        String dateString = dateTimeFormat.print(date);
        
        if(date.isAfter(DateTime.now()))
        {
            throw new InvalidDateException(fullName, dateString,
            "the date is in the future.");
        }
        else if(date.isBefore(new DateTime(1990)))
        {
            throw new InvalidDateException(fullName, dateString,
            "the date is before the foundation of the company in 1990.");
        }
        else if(date.getMonthOfYear() > 12 || date.getMonthOfYear() < 1)
        {
            throw new InvalidDateException(fullName, dateString,
            "the date uses a month that doesn't exist.");
        }
        else if(date.getDayOfMonth() > date.dayOfMonth().getMaximumValue()
                || date.getDayOfMonth() < 1)
        {
            throw new InvalidDateException(fullName, dateString,
            "the date uses a day outside the bounds of the month.");
        }
        else if(date.getHourOfDay() < 9 || date.getHourOfDay() > 18)
        {
            throw new InvalidDateException(fullName, dateString,
            "the hour the employee joined is not between 9am and 6pm.");
        }
        else if(date.getDayOfWeek() > 5)
        {
            throw new InvalidDateException(fullName, dateString,
            "the day the employee joined is not a weekday.");
        }
    }
    // get last name
    public String getLastName() {
        return lastName;
    }
    public int getEmployeeNum()
    {
        return currentEmployNum;
    }
    public int getCurrentEmployNum()
    {
        return currentEmployNum;
    }
    
    public DateTime getStartDate()
    {
        return startDate;
    }
    
    public String toString(){
        return firstName + ' ' + lastName;
    }

    public abstract double earnings() throws EarningsException;
}
