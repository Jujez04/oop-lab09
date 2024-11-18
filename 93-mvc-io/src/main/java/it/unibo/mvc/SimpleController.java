package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A simple controller for managing strings printed.
 * 
 */
public final class SimpleController implements Controller {

    private final List<String> history;
    private String nextString; 

    /**
     * Starting a new history.
     */
    public SimpleController() {
        this.history = new ArrayList<>();
    }

    /**
     * Set the next string.
     * @param inputString the next string
     */
    @Override
    public void setNextString(final String inputString) {
        this.nextString = Objects.requireNonNull(inputString, "Null values aren't accepted");
    }

    /**
     * @return the next string.
     * 
     */
    @Override
    public String getNextString() {
        return this.nextString;
    }

    /**
     * Returns the history of printed messages in stdout.
     * @return the list of printed messages
     */
    @Override
    public List<String> getHistory() {
       return List.copyOf(this.history);
    }

    /**
     * Prints the current string in the stdout.
     */
    @Override
    public void printCurrentString() {
        if (Objects.isNull(this.nextString)) {
            throw new IllegalStateException();
        }
        //System.out.println(this.nextString);
        this.history.add(nextString);
    }

}
