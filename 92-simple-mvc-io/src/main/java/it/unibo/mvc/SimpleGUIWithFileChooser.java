package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final static String TITLE = "My second Java graphical interface";
    private final static int PROPORTION = 3;
    private final JFrame frame = new JFrame(TITLE);
    private final Controller controller = new Controller();
    

    public SimpleGUIWithFileChooser() {
        final JPanel canvas = new JPanel();
        final JPanel north = new JPanel();
        final JButton save = new JButton("Save");
        final JButton browse = new JButton("Browse...");
        final JTextArea textArea = new JTextArea();
        final JTextField textField = new JTextField();
        
        canvas.setLayout(new BorderLayout());
        north.setLayout(new BorderLayout());
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas.add(textArea, BorderLayout.CENTER);
        canvas.add(save, BorderLayout.SOUTH);
        canvas.add(north, BorderLayout.NORTH);
        north.add(browse, BorderLayout.EAST);
        north.add(textField, BorderLayout.CENTER);
        textField.setText(controller.getFilePath());
        textField.setEditable(false);
        /*
         * Handlers
         */
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.writeOnCurrentFile(textArea.getText());
                } catch (IOException corruptedFile) {
                    corruptedFile.printStackTrace();
                }
            }
        });
        browse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final JFileChooser fileChooser = new JFileChooser();
                switch (fileChooser.showSaveDialog(frame)) {
                    case JFileChooser.APPROVE_OPTION:
                        controller.setCurrentFile(fileChooser.getSelectedFile());
                        textField.setText(controller.getFilePath());
                        break;
                    case JFileChooser.CANCEL_OPTION:
                        break;
                    default:
                        JOptionPane.showMessageDialog(frame, "An error has occurred");
                        break;
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

    public static void main(final String[] args) {
        new SimpleGUIWithFileChooser().display();
    }

}
