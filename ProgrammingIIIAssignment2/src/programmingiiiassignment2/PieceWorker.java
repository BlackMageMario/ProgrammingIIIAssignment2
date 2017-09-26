package programmingiiiassignment2;
import org.joda.time.DateTime;
// PieceWorker class derived from Employee

public final class PieceWorker extends Employee {

    private double wagePerPiece; // wage per piece output
    private int quantity; // output for week

    // constructor for class PieceWorker
    public PieceWorker(String first, String last,
            double wage, int numberOfItems, DateTime date)
            throws InvalidDateException {
        super(first, last, date); // call superclass constructor
        setWage(wage);
        setQuantity(numberOfItems);
    }
    //second constructor handle dates entered in manually
    public PieceWorker(String first, String last,
            double wage, int numberOfItems, 
            int year, int month, int day, int hour, int minute)
            throws InvalidDateException {
        super(first, last, year, month, day, hour, minute); // call superclass constructor
        setWage(wage);
        setQuantity(numberOfItems);
    }

    // set PieceWorker's wage
    public void setWage(double wage) {
        wagePerPiece = (wage > 0 ? wage : 0);
    }

    // set number of items output
    public void setQuantity(int numberOfItems) {
        quantity = (numberOfItems > 0 ? numberOfItems : 0);
    }

    // determine PieceWorker's earnings
    public double earnings() throws EarningsException {
        double earnings = quantity * wagePerPiece;
        if(earnings <= 0)
            throw new EarningsException();
        return earnings;
    }

    public String toString() {
        return "Piece worker: " + super.toString();
    }
}
