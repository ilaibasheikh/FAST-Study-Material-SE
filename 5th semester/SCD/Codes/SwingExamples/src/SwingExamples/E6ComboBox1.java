package SwingExamples;

import javax.swing.*;    

public class E6ComboBox1 {
	JFrame f;    
	
	E6ComboBox1(){    
	    f=new JFrame("ComboBox Example");	
	    String country[]={"Pakistan","Australia","U.S.A","England","New Zealand"};
	    JComboBox cb=new JComboBox(country);
	    cb.setBounds(50, 50,100,20);
	    f.add(cb);
	    f.setLayout(null);
	    f.setSize(400,500);
	    f.setVisible(true);
	}
	
	public static void main(String[] args) {    
	    new E6ComboBox1();         
	}  
	
	
}
