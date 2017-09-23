package programmingiiiassignment2;

// Definition of class HourlyWorker

import org.joda.time.DateTime;


public final class HourlyWorker extends Employee {

    private double wage; // wage per hour
    private double hours; // hours worked for week

    // constructor for class HourlyWorker
    public HourlyWorker(String first, String last,
            double wagePerHour, double hoursWorked, DateTime date)
            throws InvalidDateException{
        super(first, last, date); // call superclass constructor
        setWage(wagePerHour);
        setHours(hoursWorked);
    }

    // Set the wage
    public void setWage(double wagePerHour) {
        wage = (wagePerHour > 0 ? wagePerHour : 0);
    }

    // Set the hours worked
    public void setHours(double hoursWorked) {
        hours = (hoursWorked >= 0 && hoursWorked < 168
                ? hoursWorked : 0);
    }

    // Get the HourlyWorker's pay
    public double earnings() throws EarningsException{
        double earnings = wage * hours;
        if(earnings <= 0)
            throw new EarningsException();
        return earnings;
    }

    public String toString() {
        return "Hourly worker: " + super.toString();
    }
}
