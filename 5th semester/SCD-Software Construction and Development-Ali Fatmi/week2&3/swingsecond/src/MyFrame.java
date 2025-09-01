//Java's JFrame class is a part of the Swing library and is used to create windows with a title, border, and other standard window features. Handling events in a JFrame involves capturing user interactions, such as clicks, key presses, and window events, and responding to them using event listeners.
//
//Key Concepts in JFrame Event Handling:
//Event Listeners: These are interfaces in Java that define methods to handle different types of events. Common listeners used with JFrame include:
//
//ActionListener for handling button clicks.
//KeyListener for handling keyboard events.
//MouseListener and MouseMotionListener for handling mouse events.
//WindowListener for handling window events like opening, closing, or minimizing the window.
//Adding Event Listeners: To respond to an event, you need to register the appropriate listener with the component that generates the event.
//
//Example: Handling a Button Click in a JFrame
//Here’s an example of how to create a JFrame with a button and handle the button click event:

import javax.swing.*;
import java.awt.event.*;

public class MyFrame extends JFrame implements ActionListener {

    private JButton button;

    public MyFrame() {
        // Set the title of the JFrame
        setTitle("Event Handling Example");

        // Set the size of the JFrame
        setSize(300, 200);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a button
        button = new JButton("Click Me");

        // Add ActionListener to the button
        button.addActionListener(this);

        // Add the button to the JFrame
        add(button);

        // Make the frame visible
        setVisible(true);
    }

    // Implement the actionPerformed method
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            // Perform an action when the button is clicked
            JOptionPane.showMessageDialog(this, "Button was clicked!");
        }
    }

    public static void main(String[] args) {
        // Create an instance of MyFrame
        new MyFrame();
    }
}


//Explanation:
//JFrame: The MyFrame class extends JFrame, making it a window with all the standard features.
//
//JButton: A button is created using new JButton("Click Me").
//
//ActionListener: The MyFrame class implements ActionListener, which requires the implementation of the actionPerformed method.
//
//Registering the Listener: The button's action listener is set using button.addActionListener(this), meaning that when the button is clicked, the actionPerformed method is called.
//
//Handling the Event: Inside actionPerformed, a simple message dialog is displayed when the button is clicked.
//
//Common JFrame Events:
//Window Events:
//
//WindowListener can be used to handle events like window opening, closing, minimizing, etc.
//addWindowListener(new WindowAdapter() {
//    public void windowClosing(WindowEvent e) {
//        System.out.println("Window is closing");
//    }
//});
//
//Key Events:
//
//KeyListener can be used to capture key presses and releases.
//
//addKeyListener(new KeyAdapter() {
//    public void keyPressed(KeyEvent e) {
//        System.out.println("Key pressed: " + e.getKeyChar());
//    }
//});
//
//
//Mouse Events:
//
//MouseListener and MouseMotionListener can handle mouse clicks, movement, and dragging.
//
//button.addMouseListener(new MouseAdapter() {
//    public void mouseClicked(MouseEvent e) {
//        System.out.println("Mouse clicked at: " + e.getPoint());
//    }
//});
//
