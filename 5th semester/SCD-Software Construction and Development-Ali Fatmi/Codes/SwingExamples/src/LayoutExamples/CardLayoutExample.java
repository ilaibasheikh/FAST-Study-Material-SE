package LayoutExamples;

import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import javax.swing.*;  

public class CardLayoutExample extends JFrame{
	private int currCard = 1;
	private CardLayout layout;
	
	public CardLayoutExample() {
		setTitle("Card Layout Example");
		setSize(400,400);
		
		JPanel panel = new JPanel();
		layout = new CardLayout();
		
		//set layout for your panel
		panel.setLayout(layout);
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		
		//creating labels for each card
		JLabel label1 = new JLabel("Card 1");
		JLabel label2 = new JLabel("Card 2");
		JLabel label3 = new JLabel("Card 3");
		JLabel label4 = new JLabel("Card 4");
		
		//placing labels in panel(card)
		panel1.add(label1);
		panel2.add(label2);
		panel3.add(label3);
		panel4.add(label4);
		
		//adding panels(cards) to the main panel
		panel.add(panel1, "1");
		panel.add(panel2, "2");
		panel.add(panel3, "3");
		panel.add(panel4, "4");
		
		JPanel buttonPanel = new JPanel();
		
		JButton firstB = new JButton("first");
		JButton nextB = new JButton(">>");
		JButton prevB = new JButton("<<");
		JButton lastB = new JButton("last");
		
		buttonPanel.add(firstB);
		buttonPanel.add(nextB);
		buttonPanel.add(prevB);
		buttonPanel.add(lastB);
		
		firstB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				layout.first(panel);
				currCard = 1;
			}
		});
		
		lastB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				layout.last(panel);
				currCard = 4;
			}
		});
		
		nextB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currCard < 4) {
					currCard += 1;
					layout.show(panel, "" +currCard);
				}
				
			}
		});
		
		prevB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currCard > 1) {
					currCard -= 1;
					layout.show(panel, "" +currCard);
				}
				
			}
		});
		
		// using to get the content pane  
		getContentPane().add(panel, BorderLayout.NORTH);  
		  
		// using to get the content pane  
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);  
	}

	public static void main(String[] args) {
		CardLayoutExample ex = new CardLayoutExample();
		ex.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ex.setVisible(true);

	}

}
