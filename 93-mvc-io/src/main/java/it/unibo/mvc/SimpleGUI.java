package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final String TITLE = SimpleGUI.class.getSimpleName();
    private final JFrame frame = new JFrame(TITLE);
    private static final int PROPORTION = 3;
    private final Controller controller = new SimpleController();

    /**
     * Constructor that initialize the GUI.
     */
    public SimpleGUI() {
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        final JPanel southCanvas = new JPanel();
        canvas.add(southCanvas, BorderLayout.SOUTH);
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        southCanvas.setLayout(new BorderLayout());
        final JTextArea textArea = new JTextArea();
        canvas.add(textArea, BorderLayout.CENTER);
        final JTextField textField = new JTextField();
        canvas.add(textField, BorderLayout.NORTH);
        final JButton print = new JButton("Print");
        final JButton showHistory = new JButton("Show history");
        southCanvas.add(print, BorderLayout.WEST);
        southCanvas.add(showHistory, BorderLayout.EAST);
        /*
         * Handlers
         */
        print.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent clicked) {
                controller.setNextString(textField.getText());
                controller.printCurrentString();
            }
        });

        showHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {  
                final StringBuffer buffer = new StringBuffer();
                for (final String line : controller.getHistory()) {
                   buffer.append(line).append('\n');
                }
                textArea.setText(buffer.toString());
            }
        });
    }

    /**
     * Display the frame implemented in the constructor.
     */
    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setVisible(true);
    }

    /**
     * Main method for initializing our GUI.
     * @param args in this case nothing
     */
    public static void main(final String[] args) {
        new SimpleGUI().display();
    }
}
