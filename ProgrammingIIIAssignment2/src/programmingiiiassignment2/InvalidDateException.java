/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmingiiiassignment2;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author Eamonn Hannon
 */
public class InvalidDateException extends Exception {
    /**
     * Creates a new instance of <code>InvalidDateException</code> without
     * detail message.
     */
    public InvalidDateException() {
        super("Invalid date supplied.");
    }

    /**
     * Constructs an instance of <code>InvalidDateException</code> with the
     * specified detail message.
     *
     * @param name the name of the person
     * @param date the date in string format
     * @param reason the reason it was invalid
     */
    public InvalidDateException(String name, String date, String reason) {
        super(name + " join date " + date + " is invalid\n"
                + "Reason: " + reason);
    }
}
