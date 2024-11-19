package it.unibo.mvc;

import java.io.*;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private final static String SEPARATOR = System.getProperty("file.separator");
    private final static String STD_FILE = System.getProperty("user.home") + SEPARATOR + "output.txt";
    private File currentFile;

    public Controller(File file) {
        this.currentFile = file;
    }

    public Controller() {
        this(new File(STD_FILE));
    }

    /**
     * Set the current file.
     * @param file
     */
    public void setCurrentFile(File file) {
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
     * Write what is passed as parameter
     * @param content 
     * @throws IOException
     */
    public void writeOnCurrentFile(String content) throws IOException {

        try (final BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter(
					new FileOutputStream(this.currentFile),"UTF-8"))) {
            bw.write(content);
        } 
    }
}
