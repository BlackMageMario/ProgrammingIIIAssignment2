/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmingiiiassignment2;

/**
 *
 * @author Eamonn Hannon
 */
public class EarningsException extends Exception {

    /**
     * Creates a new instance of <code>EarningsException</code> without detail
     * message.
     */
    public EarningsException() {
        super("Error: earnings below or equal to 0.");
    }

    /**
     * Constructs an instance of <code>EarningsException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public EarningsException(String msg) {
        super(msg);
    }
}
