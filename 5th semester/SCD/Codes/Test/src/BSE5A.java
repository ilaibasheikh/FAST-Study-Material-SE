import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JEditorPane;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTree;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SpringLayout;
import java.awt.FlowLayout;

public class BSE5A extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BSE5A frame = new BSE5A();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BSE5A() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
		panel.add(internalFrame);
		internalFrame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				System.out.println("Focus Gained here");
			}
			@Override
			public void focusLost(FocusEvent e) {
				System.out.println("Focus Gaya");
			}
		});
		internalFrame.getContentPane().add(editorPane);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		buttonGroup.add(chckbxNewCheckBox);
		internalFrame.getContentPane().add(chckbxNewCheckBox, BorderLayout.NORTH);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("New check box");
		buttonGroup.add(chckbxNewCheckBox_1);
		chckbxNewCheckBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("hello");
			}
		});
		internalFrame.getContentPane().add(chckbxNewCheckBox_1, BorderLayout.SOUTH);
		internalFrame.setVisible(true);
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton);
		
		JSlider slider = new JSlider();
		contentPane.add(slider, BorderLayout.NORTH);
	}

}
