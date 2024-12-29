


import javax.swing.ImageIcon;  
import javax.swing.JFrame;  
import javax.swing.JLabel;  
import javax.swing.JScrollPane;  
public class ScrollPaneDemo extends JFrame {  
	public ScrollPaneDemo() {  
		super("ScrollPane Demo");  
		ImageIcon img = new ImageIcon("C:\\Users\\Hp\\Desktop\\5 semester\\SCD\\Codes\\Test\\src\\button-859346_1280.png");
		  
		JScrollPane png = new JScrollPane(new JLabel(img));  
		  
		getContentPane().add(png);  
		setSize(100,100);  
		setVisible(true);  
	}  
	  
	public static void main(String[] args) {  
		new ScrollPaneDemo();  
	}  
} 