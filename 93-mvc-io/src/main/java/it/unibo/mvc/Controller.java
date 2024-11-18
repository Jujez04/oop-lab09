package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {

    void setNextString(String inputString);

    String getNextString();

    List<String> getHistory();

    void printCurrentString();
}
