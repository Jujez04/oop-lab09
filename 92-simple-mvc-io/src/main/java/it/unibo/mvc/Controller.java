package it.unibo.mvc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private static final String SEPARATOR = System.getProperty("file.separator");
    private static final String STD_FILE = System.getProperty("user.home") + SEPARATOR + "output.txt";
    private File currentFile;

    /**
     * Constructor that intializes a new controller 
     * for the file passed as argument.
     * @param file 
     */
    public Controller(final File file) {
        this.currentFile = file;
    }

    /**
     * Constructor for the default case.
     */
    public Controller() {
        this(new File(STD_FILE));
    }

    /**
     * Set the current file.
     * @param file
     */
    public void setCurrentFile(final File file) {
        this.currentFile = file;
    }

    /**
     * Get the current file. 
     * @return the current file
     */
    public File getCurrentFile() {
        return this.currentFile;
    }

    /**
     * Get the absolute path of the current file.
     * @return the absolute path of the current file
     */
    public String getFilePath() {
        return this.currentFile.getAbsolutePath();
    }

    /**
     * Write what is passed as parameter.
     * @param content 
     * @throws IOException
     */
    public void writeOnCurrentFile(final String content) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.currentFile), "UTF-8"))) {
            bw.write(content);
        } 
    }
}
