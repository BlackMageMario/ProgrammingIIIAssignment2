package programmingiiiassignment2;
import org.joda.time.DateTime;
// Boss class derived from Employee.

public final class Boss extends Employee {

    private double weeklySalary;

    // constructor for class Boss
    public Boss(String first, String last, double salary, DateTime date)
        throws InvalidDateException{
        super(first, last, date); // call superclass constructor
        setWeeklySalary(salary);
    }
    //second constructor handle dates entered in manually
    public Boss(String first, String last, double salary,
            int year, int month, int day, int hour, int minute)
        throws InvalidDateException{
        super(first, last, year, month, day, hour, minute); // call superclass constructor
        setWeeklySalary(salary);
    }

    // set Boss's salary
    public void setWeeklySalary(double salary) {
        weeklySalary = (salary > 0 ? salary : 0);
    }

    // get Boss's pay
    public double earnings() throws EarningsException {
        if(weeklySalary <= 0)
            throw new EarningsException();
        return weeklySalary;
    }

    // get String representation of Boss's name
    public String toString() {
        return "Boss: " + super.toString();
    }
} // end class Boss
