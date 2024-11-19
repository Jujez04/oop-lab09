package it.unibo.mvc;

import java.awt.*;
import javax.swing.*;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final static String TITLE = SimpleGUI.class.getSimpleName();
    private final static int PROPORTION = 3;
    private final JFrame frame = new JFrame(TITLE);
    

    public SimpleGUI() {
        final JPanel canvas = new JPanel();
        final JButton save = new JButton("Save");
        final JTextArea textArea = new JTextArea();
        canvas.setLayout(new BorderLayout());
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas.add(textArea, BorderLayout.CENTER);
        canvas.add(save, BorderLayout.SOUTH);
    }

    public void display() {
        final Dimension sizeScreen = Toolkit.getDefaultToolkit().getScreenSize();
        final int width = (int) sizeScreen.getWidth();
        final int heigth = (int) sizeScreen.getHeight();
        frame.setSize(width / PROPORTION, heigth / PROPORTION);
        frame.setVisible(true);
    }

    public static void main(final String[] args) {
        new SimpleGUI().display();
    }
}
