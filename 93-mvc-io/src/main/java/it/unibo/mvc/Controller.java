package it.unibo.mvc;

import java.util.List;

/**
 * Interface of a controller that manages strings.
 */
public interface Controller {

    /**
     * Set the next string.
     * @param inputString the next string
     */
    void setNextString(String inputString);

    /**
     * @return the next string.
     */
    String getNextString();

    /**
     * Get the next string.
     * @return the list of printed messages
     */
    List<String> getHistory();

    /**
     * Prints the current string in the stdout.
     */
    void printCurrentString();
}
