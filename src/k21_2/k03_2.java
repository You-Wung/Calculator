package k21_2;

import javax.swing.*; 
import java.awt.Color; 
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class k03_2 extends JFrame implements ActionListener {
	public static void main(String[] args) {
		JFrame jf = new JFrame("k03_2");
		JLabel lb = new JLabel("0 ");
		JTextField jt1 = new JTextField(20);
		JTextField jt2 = new JTextField(20);
		JButton bt = new JButton("Button");
		
		jf.setSize(300, 500);
		jf.setLayout(null);//자동정렬off
		
		lb.setForeground(Color.white);
		lb.setBounds(20, 20, 250, 100);
		lb.setOpaque(true);
		lb.setFont(new Font("Arial Rounded MT", Font.PLAIN, 30));
		lb.setBackground(Color.black);
		lb.setHorizontalAlignment(lb.RIGHT);
		
		jt1.setBounds(20, 200, 250, 50);
		jt2.setBounds(20, 300, 250, 50);
		bt.setBounds(20, 400, 250, 50);
		bt.addActionListener(null);
		
		jf.add(bt);
		jf.add(jt1);
		jf.add(jt2);
		jf.add(lb);
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jf.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String buf = jt1.
	}

}
