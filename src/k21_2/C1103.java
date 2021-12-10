package k21_2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class C1103 extends JFrame implements ActionListener {
	JFrame			j;
	JPanel			panel01, panel02, panel03;
	JButton			btn1, btn2, btn3;
//	JButton 		btn[][][] = new JButton[10][10][10]; //배열선언
	JButton 		btn[] = new JButton[10];
	BorderLayout 	borderlayout;
	GridLayout		gridlayout;
	
	C1103(){
		
		j = new JFrame("test");
		panel01 = new JPanel();
		panel02 = new JPanel();
		panel03 = new JPanel();
		btn1 = new JButton("btn1");
		btn2 = new JButton("btn2");
		btn3 = new JButton("btn3");
		borderlayout = new BorderLayout();
		gridlayout = new GridLayout(3, 4);
//		for(int i=0; i<btn.length; i++) {
//			for(int j=0; j<btn[0].length; j++) {
//				for(int k=0; k<btn[0][0].length; k++) {
//					btn[i][j][k] = new JButton(Integer.toString(i) + Integer.toString(j) + Integer.toString(k));
//					panel01.add(btn[i][j][k]);												
//				}
//			}
//		}
		
		j.setDefaultCloseOperation(EXIT_ON_CLOSE);
		j.setSize(500, 750);
		j.getContentPane().setBackground(Color.BLUE);
		j.setLayout(null);
		
		panel01.setBounds(20, 20, 440, 200);
		panel02.setBounds(20, 240, 440, 200);
		panel03.setBounds(20, 460, 440, 200);
		panel01.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel02.setLayout(borderlayout);
		panel03.setLayout(gridlayout);
		
		for(int i=0; i<btn.length; i++) {
			btn[i] = new JButton("btn" + i);
			if (i==1)
				panel02.add("North", btn[i]);
			if (i==0)
				panel02.add("South", btn[i]);
			else
				panel03.add(btn[i]);
		}
		
		panel01.add(btn1);
		panel01.add(btn2);
		panel01.add(btn3);

		j.add(panel01);
		j.add(panel02);
		j.add(panel03);
		j.setVisible(true);
	}
	
	public static void main(String[] args) {
		new C1103();
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}

}
