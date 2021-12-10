package k21_2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
/*
 * 자바의 3요소
 * 변수
 * 생성자: 클래스와 같은 이름
 * 메소드
 */
public class C2017104139_backup extends JFrame implements ActionListener {
	JFrame			j;
	JButton			bt01, bt02;
	JButton			bt[] = new JButton[16];
	JTextField		tf01, tf02;//text입력받기
	JLabel			lb;//출력
	Font			f;
	JMenuBar		bar;
	JMenu			menu, menu2;
	JMenuItem		i1, i2, i3, i4;
	JRadioButton	ra1, ra2, ra3, ra4;//buttongroup이용해야지 하나만 선택가능
	ButtonGroup		gp1, gp2;//동시선택 불가
	JCheckBox		ck1, ck2, ck3, ck4;
	JPanel			panel00;
	C2017104139_backup(){
		//checkbox
		ck1 = new JCheckBox("Red Velvet");
		ck2 = new JCheckBox("Black Pink");
		ck3 = new JCheckBox("IZONE");
		ck4 = new JCheckBox("Pinkle");
		ck1.setBounds(50, 200, 100, 30);
		ck2.setBounds(150, 200, 100, 30);
		ck3.setBounds(250, 200, 60, 30);
		ck4.setBounds(320, 200, 70, 30);
		//radio
		ra1 = new JRadioButton("seoul");
		ra2 = new JRadioButton("suwon");
		ra3 = new JRadioButton("man");
		ra4 = new JRadioButton("woman");
		ra1.setBounds(50, 10, 70, 30);
		ra2.setBounds(120, 10, 70, 30);
		ra3.setBounds(260, 10, 50, 30);
		ra4.setBounds(320, 10, 70, 30);
		gp1 = new ButtonGroup();
		gp1.add(ra1);
		gp1.add(ra2);
		gp2 = new ButtonGroup();
		gp2.add(ra3);
		gp2.add(ra4);
		//menu
		bar = new JMenuBar();
		menu = new JMenu("file");
		i1 = new JMenuItem("help");
		i2 = new JMenuItem("exit");
		i3 = new JMenuItem("version");
		i4 = new JMenuItem("made by");
		i1.addActionListener(this);
		i2.addActionListener(this);
		i3.addActionListener(this);
		i4.addActionListener(this);
		menu.add(i1);
		menu.add(i2);
		
		menu2 = new JMenu("info");
		menu2.add(i3);
		menu2.add(i4);
		bar.add(menu);
		bar.add(menu2);
		//font
		f = new Font("Terminal", Font.BOLD, 30);
		//window
		j = new JFrame("C_2017104138");
		j.setSize(470,800);
		j.setDefaultCloseOperation(EXIT_ON_CLOSE);//자동꺼짐
		//import로하면 exit_on_close를 내꺼처럼 사용못함 should be JFrame.EXIT_ON_CLOSE
		j.setLayout(null);//자동정렬 off
		//button
		bt01 = new JButton("calc");//시험7번 - 이 부분 지워두고 실행이 안된다 -> 해결방법
		bt01.setBounds(250, 250, 150, 60);
		bt01.setFont(f);
		bt01.addActionListener(this);
		//action 감지 시, 신고 -> actionPerformed
		bt02 = new JButton("reset");
		bt02.setBounds(50, 250, 150, 60);
		bt02.setFont(f);
		bt02.addActionListener(this);
		//label
		lb = new JLabel("0");
		lb.setBounds(50, 50, 350, 80);
		lb.setOpaque(true);//투명도
		lb.setBackground(Color.gray);
		lb.setHorizontalAlignment(JLabel.RIGHT);//정렬
		lb.setFont(new Font("Terminal", Font.BOLD, 70));
		//TextField
		tf01 = new JTextField();
		tf01.setBounds(50, 150, 150, 40);
		tf02 = new JTextField();
		tf02.setBounds(250, 150, 150, 40);
		//panel
		panel00 = new JPanel();
		panel00.setBounds(50, 350, 350, 300);
		panel00.setLayout(new GridLayout(4, 4));
		set_jbutton();;
		//add
		j.add(panel00);
		j.setJMenuBar(bar);
		j.add(ck1);
		j.add(ck2);
		j.add(ck3);
		j.add(ck4);
		j.add(ra1);
		j.add(ra2);
		j.add(ra3);
		j.add(ra4);
		j.add(tf01);
		j.add(tf02);
		j.add(lb);
		j.add(bt01);//시험7번 - 이 부분 지워두고 실행이 안된다 -> 해결방법
		j.add(bt02);
		j.setVisible(true);
	}
	
	public void set_jbutton() {
		int j;
		
		j = 0;
		for(int i=1; i<bt.length + 1; i++) {
			if (i == 4)
				bt[i - 1] = new JButton("+");//3
			else if (i == 8)
				bt[i - 1] = new JButton("/");//7
			else if (i == 12)
				bt[i - 1] = new JButton("*");//11
			else if (i == 13)
				bt[i - 1] = new JButton(".");//12
			else if (i == 14)
				bt[i - 1] = new JButton("0");//13
			else if (i == 15)
				bt[i - 1] = new JButton("C");//14
			else if (i == 16)
				bt[i - 1] = new JButton("=");//15
			else
				bt[i - 1] = new JButton(Integer.toString(i));
			bt[i - 1].addActionListener(this);
			panel00.add(bt[i - 1]);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		String s1;
		String s2;
		String com;
		
		if(e.getSource() == bt[15]) {
			try {
				lb.setBackground(Color.YELLOW);
				s1 = tf01.getText();
				s2 = tf02.getText();
				tf01.setText("");
				tf02.setText("");				
				com = Integer.toString(Integer.parseInt(s1) + Integer.parseInt(s2));
				lb.setText(com);				
			} catch(Exception ex) {
				lb.setText("error");				
			}
		}else if(e.getSource() == bt[14]) {
			tf01.setText("");
			tf02.setText("");
			lb.setBackground(Color.pink);
			lb.setText("0");
		}else if (e.getSource() == i1) {
			lb.setText("no help");
		}else if (e.getSource() == i2) {
			System.exit(0);
		}else if (e.getSource() == i3) {
			lb.setText("v1.0");
		}else if (e.getSource() == i4) {
			lb.setText("wazoski");
		}
	}
	
	public static void main(String[] args) {
		C2017104139_backup c;
		c = new C2017104139_backup();
		c.lb.setBackground(Color.magenta);
	}

}
