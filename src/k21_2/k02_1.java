package k21_2;

import java.awt.Color; 

import javax.swing.JButton;
import javax.swing.JFrame;

public class k02_1 extends JFrame{
	public static void main(String[] args) {
		JFrame jf = new JFrame("TEST");
		jf.setSize(800, 800);
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jf.setLayout(null);//자동정렬 off
		JButton btn;
		btn = new JButton("BUTTON");
		btn.setBackground(Color.cyan);
		btn.setBounds(100, 100, 150, 150);

		JButton btn2;
		btn2 = new JButton("BUTTON");
		btn2.setBackground(Color.red);
		btn2.setBounds(100, 300, 150, 150);

		jf.add(btn);
		jf.add(btn2);
		
		jf.setVisible(true);
	}
}
