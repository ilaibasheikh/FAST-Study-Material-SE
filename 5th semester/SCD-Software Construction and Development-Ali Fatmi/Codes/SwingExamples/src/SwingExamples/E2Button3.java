package SwingExamples;

import javax.swing.*; 

public class E2Button3 {
	
	E2Button3() {
		JFrame f=new JFrame("Button Example");            
		JButton b=new JButton(new ImageIcon("button-859346_1280.png"));    
		b.setBounds(100,100,100, 40);    
		
		f.add(b);    
		
		f.setSize(300,400);    
		f.setLayout(null);    
		f.setVisible(true);    
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
	}
	
	public static void main(String[] args) {    
	    new E2Button3();    
	}    
}
