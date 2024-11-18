package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private final List<String> history;
    private String nextString; 

    public SimpleController() {
        history = new ArrayList<>();
    }

    @Override
    public void setNextString(final String inputString) {
        this.nextString = Objects.requireNonNull(inputString, "Null values aren't accepted");
    }

    @Override
    public String getNextString() {
        return this.nextString;
    }

    @Override
    public List<String> getHistory() {
       return List.copyOf(this.history);
    }

    @Override
    public void printCurrentString() {
        if (Objects.isNull(this.nextString)) {
            throw new IllegalStateException();
        }
        System.out.println(this.nextString);
        this.history.add(nextString);
    }

}
