package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final String TITLE = "My first Java graphical interface";
    private static final int PROPORTION = 3;
    private final JFrame frame = new JFrame(TITLE);
    private final Controller controller = new Controller();
    /**
     * Constructor for building the new GUI.
     */
    public SimpleGUI() {
        final JPanel canvas = new JPanel();
        final JButton save = new JButton("Save");
        final JTextArea textArea = new JTextArea();
        canvas.setLayout(new BorderLayout());
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas.add(textArea, BorderLayout.CENTER);
        canvas.add(save, BorderLayout.SOUTH);
        /*
         * Handlers
         */
        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    controller.writeOnCurrentFile(textArea.getText());
                } catch (IOException corruptedFile) {
                    JOptionPane.showMessageDialog(frame, corruptedFile.getMessage());
                }
            }
        });
    }

    /**
     * Method that displays the frame implemented in the constructor.
     */
    public void display() {
        final Dimension sizeScreen = Toolkit.getDefaultToolkit().getScreenSize();
        final int width = (int) sizeScreen.getWidth();
        final int heigth = (int) sizeScreen.getHeight();
        frame.setSize(width / PROPORTION, heigth / PROPORTION);
        frame.setVisible(true);
    }

    /**
     * Main method.
     * @param args
     */
    public static void main(final String[] args) {
        new SimpleGUI().display();
    }
}
