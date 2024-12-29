import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JInternalFrame;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTree;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BSE5B extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BSE5B frame = new BSE5B();
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
	public BSE5B() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
		contentPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("hello");
		buttonGroup.add(chckbxNewCheckBox);
		internalFrame.getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("New check box");
		buttonGroup.add(chckbxNewCheckBox_1);
		internalFrame.getContentPane().add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("New check box");
		buttonGroup.add(chckbxNewCheckBox_2);
		internalFrame.getContentPane().add(chckbxNewCheckBox_2);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		internalFrame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		internalFrame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("New radio button");
		buttonGroup_1.add(rdbtnNewRadioButton_2);
		internalFrame.getContentPane().add(rdbtnNewRadioButton_2);
		
		JTree tree = new JTree();
		internalFrame.getContentPane().add(tree, BorderLayout.NORTH);
		
		JInternalFrame internalFrame_1 = new JInternalFrame("New JInternalFrame");
		contentPane.add(internalFrame_1);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("hi");
			}
		});
		internalFrame_1.getContentPane().add(btnNewButton, BorderLayout.NORTH);
		internalFrame_1.setVisible(true);
		internalFrame.setVisible(true);
	}

}
