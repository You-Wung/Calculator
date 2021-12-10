/*
 * 2학년 C반 유태웅 2017104138
 * 1. 소수점 부분: double 로 변환했음.
 * 
 * 2. 제곱: 숫자만 입력 후 버튼 누를 시, 제곱된 수가 출력됨.
 * 
 * 3. 백스페이스 버튼: 지우기 버튼
 * 
 * 4. 실행 시, 알림창 표시와 사진 출력
 * 
 * 5. 기존 JFrame 사진을 아이콘 모양 바꾸기
 * 
 * 6. 체크박스: label 색상 변경
 * 
 * 7. 메뉴바
 *   help(label출력), exit(종료), version(버전출력)
 *   madeby(알림창), button(색상변경)
 *   
 * 8. Border클래스 상속한 RoundedBorder 클래스 선언버튼의 테두리를 둥글게 변경
 * 
 * 9. 연산 시 숫자 뒤에 ".0" 이 나올 경우 출력을 하지 않음
 *    ex) 9 + 9 = 18.0 에서 .0 을 출력하지 않음.
 *    
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;


@SuppressWarnings("serial")
public class C2017104138 extends JFrame implements ActionListener{
	JFrame			j;
	String			st[] = {"1", "2", "3", "+",
							"4", "5", "6", "-",
							"7", "8", "9", "/",
							"C", "0", ".", "x" };
	JButton			bt[] = new JButton[st.length];
	JButton			cal, bs, db;
	JLabel			lb;//출력
	JMenuBar		bar;
	JMenu			menu[] = new JMenu[3];
	JMenuItem		i[] = new JMenuItem[8];
	JCheckBox		cb;
	JPanel			panel00;
	C2017104138() {
		cb = new JCheckBox("Dark");
		cb.setBounds(35, 12, 70, 30);
		cb.setBackground(Color.white);
		cb.addActionListener(this);

		//menu
		bar = new JMenuBar();
		menu[0] = new JMenu("menu");
		i[0] = new JMenuItem("help");
		i[1] = new JMenuItem("exit");
		i[0].addActionListener(this);
		i[1].addActionListener(this);
		menu[0].add(i[0]);
		menu[0].add(i[1]);
		menu[1] = new JMenu("info");
		i[2] = new JMenuItem("version");
		i[3] = new JMenuItem("made by");
		i[2].addActionListener(this);
		i[3].addActionListener(this);
		menu[1].add(i[2]);
		menu[1].add(i[3]);
		menu[2] = new JMenu("button");
		i[4] = new JMenuItem("darkmode");
		i[5] = new JMenuItem("whitemode");
		i[4].addActionListener(this);
		i[5].addActionListener(this);
		menu[2].add(i[4]);
		menu[2].add(i[5]);
		for(int i=0; i<menu.length; i++)
			bar.add(menu[i]);
		j = new JFrame("계산기");
		j.setSize(366,555);
		j.getContentPane().setBackground( Color.white );
		j.setDefaultCloseOperation(EXIT_ON_CLOSE);//자동꺼짐
		j.setLayout(null);//자동정렬 off
		j.setResizable(false);
		try {
			URL url = new URL("https://as1.ftcdn.net/v2/jpg/04/38/83/10/1000_F_438831016_mgvKbm8gOVGF0ujS1mxQfjQCYTp5KtEw.jpg");
			Image image = ImageIO.read(url);
			j.setIconImage(image);
		} catch (MalformedURLException e) { //URL error
		} catch (IOException e) { } //read error
		//label
		lb = new JLabel("0");
		lb.setBounds(0, 50, 350, 80);
		lb.setOpaque(true);//투명도
		lb.setBackground(Color.white);
		lb.setHorizontalAlignment(JLabel.RIGHT);//정렬
		lb.setFont(new Font("Terminal", Font.BOLD, 30));
		//panel
		panel00 = new JPanel();
		panel00.setBounds(0, 190, 350, 300);
		panel00.setLayout(new GridLayout(4, 4));
		set_jbutton();
		i[5].doClick();
		//add
		j.add(cal);
		j.add(panel00);
		j.setJMenuBar(bar);
		j.add(cb);
		j.add(db);
		j.add(lb);
		j.add(bs);
		j.setVisible(true);
	}
	public void option_pane() {
		try {
			URL url = new URL("https://downloadwap.com/thumbs2/wallpapers/p2ls/25/movies/BSUOs5Za.jpg");
			Image image = ImageIO.read(url);
			image = image.getScaledInstance(230, 170, Image.SCALE_SMOOTH);
			UIManager.put("OptionPane.background", Color.white);
			UIManager.put("Panel.background", Color.white);
			UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Terminal", Font.BOLD, 18)));
			UIManager.put("OptionPane.background", new ColorUIResource(255, 255, 255));
			JOptionPane.showMessageDialog(null, "2017104138 유태웅" + "\n2학년 C반" + "\n21년도 2학기 JAVA 과제", "만든이", JOptionPane.OK_OPTION, new ImageIcon(image));
		} catch (MalformedURLException e) { //URL error
		} catch (IOException e) { } //read error
	}
	public void set_jbutton() {
		for(int i=0; i<bt.length; i++) {
			bt[i] = new JButton(st[i]);
			bt[i].addActionListener(this);
			bt[i].setBackground(Color.black);
			bt[i].setForeground(new Color(255, 255, 255));
			bt[i].setFont(new Font("Terminal", Font.BOLD, 20));
			bt[i].setOpaque(true);
			bt[i].setBorder(new RoundedBorder(35));
			panel00.add(bt[i]);
		}
		db = new JButton("x²");
		db.setForeground(Color.white);
		db.setBounds(130, 7, 100, 40);
		db.setBackground(Color.black);
		db.setOpaque(true);
//		db.setBorderPainted(false);
		db.setBorder(new RoundedBorder(25));
		db.setFont(new Font("Terminal", Font.PLAIN, 20));
		db.addActionListener(this);
		
		cal = new JButton("Calculate");
		cal.setBounds(0, 130, 350, 60);
		cal.setBackground(Color.black);
		cal.setOpaque(true);
		cal.setFont(new Font("Terminal", Font.BOLD, 20));
		cal.setForeground(new Color(255, 255, 255));
		cal.setBorder(new RoundedBorder(25));
//		cal.setBorderPainted(false);
		cal.addActionListener(this);
		
		bs = new JButton("←");
		bs.setForeground(Color.white);
		bs.setFont(new Font("Terminal", Font.BOLD, 20));
		bs.setBounds(240, 7, 100, 40);
		bs.setBackground(Color.black);
		bs.addActionListener(this);
		bs.setOpaque(true);
//		bs.setBorderPainted(false);
		bs.setBorder(new RoundedBorder(25));
	}
	public boolean last_is_num(String s)
	{
		char buf = s.charAt(s.length() - 1);
		int i = buf - '0';
		if (i >= 0 && i <= 9)
			return (true);
		return (false);
	}
	public boolean check(String s)
	{
		for(int i=0; i<s.length(); i++)
		{
			if (s.charAt(i) == 'v' || s.charAt(i) == 'c' || s.charAt(i) == 'w' || s.charAt(i) == 'E' 
					|| s.charAt(i) == 'N' || s.charAt(i) == 'I' || s == "2017104138")
				return (true);
		}
		return (false);
	}
	public void actionPerformed(ActionEvent e) {
		String s1;
		s1 = lb.getText();
		if (cb.isSelected() == true) {
			lb.setBackground(Color.black);
			lb.setForeground(Color.white);
		}if (cb.isSelected() == false) {
			lb.setBackground(Color.white);
			lb.setForeground(Color.black);
		}
		if(e.getSource() == bt[12]) {
			lb.setText("0");
		}else if (e.getSource() == i[0]) {
			lb.setText("work harder");
		}else if (e.getSource() == i[1]) {
			System.exit(0);
		}else if (e.getSource() == i[2]) {
			lb.setText("v1.0");
		}else if (e.getSource() == i[3]) {
			option_pane();
		}else if (e.getSource() == i[4]) {
			for(int i=0; i<bt.length; i++) {
				bt[i].setBackground(Color.black);
				bt[i].setForeground(new Color(255, 255, 255));
			}
			db.setBackground(Color.black);
			db.setForeground(new Color(255, 255, 255));
			bs.setBackground(Color.black);
			bs.setForeground(new Color(255, 255, 255));
			cal.setBackground(Color.black);
			cal.setForeground(new Color(255, 255, 255));
		}else if (e.getSource() == i[5]) {
			for(int i=0; i<bt.length; i++) {
				bt[i].setBackground(Color.white);
				bt[i].setForeground(new Color(0, 0, 0));
			}
			db.setBackground(Color.white);
			db.setForeground(new Color(0, 0, 0));
			bs.setBackground(Color.white);
			bs.setForeground(new Color(0, 0, 0));
			cal.setBackground(Color.white);
			cal.setForeground(new Color(0, 0, 0));
		}else if (e.getSource() == bs) {
			if (s1.length() > 0)
			{
				s1 = s1.substring(0, s1.length() - 1);
				lb.setText(s1);
			}
		}else if (e.getSource() == bt[0] || e.getSource() == bt[1] || e.getSource() == bt[2] || e.getSource() == bt[4]
				|| e.getSource() == bt[5] || e.getSource() == bt[6] || e.getSource() == bt[8] || e.getSource() == bt[9]
				|| e.getSource() == bt[10] || e.getSource() == bt[13]) {
			if (s1.length() > 15)
			{
				lb.setText("Not over 15 num");
				return ;
			}
			int i;
			for(i=0; i<bt.length && e.getSource() != bt[i]; i++);
			if (i >= 0 && i <= 2){
				if (s1 == "0")
					lb.setText(Integer.toString(i + 1));
				else
					lb.setText(s1 + Integer.toString(i + 1));
			}else if (i >= 4 && i <= 6) {
				if (s1 == "0")
					lb.setText(Integer.toString(i));
				else
					lb.setText(s1 + Integer.toString(i));
			}else if (i >= 8 && i <= 10) {
				if (s1 == "0")
					lb.setText(Integer.toString(i));
				else
					lb.setText(s1 + Integer.toString(i - 1));
			}else if (i == 13) {
				if (s1 != "0")
					lb.setText(s1 + "0");
			}
		}else if (e.getSource() == bt[3]) {// +
			if (last_is_num(s1))
				lb.setText(s1 + "+");
		}else if (e.getSource() == bt[7]) {// -
			if (last_is_num(s1))
				lb.setText(s1 + "-");
		}else if (e.getSource() == bt[11]) {// /
			if (last_is_num(s1))
				lb.setText(s1 + "/");
		}else if (e.getSource() == bt[15]) {// *
			if (last_is_num(s1))
				lb.setText(s1 + "*");
		}else if (e.getSource() == bt[14]) {// .
			int i, j;
			i = 0;
			j = 0;
			if (s1.indexOf("+") != -1)//dot 있으면 위치
				i = s1.lastIndexOf("+");
			else if (s1.indexOf("-") != -1)
				i = s1.lastIndexOf("-");
			else if (s1.indexOf("/") != -1)
				i = s1.lastIndexOf("/");
			else if (s1.indexOf("*") != -1)
				i = s1.lastIndexOf("*");
			if (last_is_num(s1))
				j = s1.lastIndexOf(".");
			if (s1.charAt(s1.length() - 1) == '.')
				return ;
			if (i >= j)
				lb.setText(s1 + ".");
		} else if (e.getSource() == cal) {
			cal(s1);
		} else if (e.getSource() == db) {
			if (s1.contains("\\+|\\-|\\*|\\/"))
				return ;
			Double d = Double.parseDouble(s1);
			if (d < 0)
				d = -d;
			try {
				s1 = Double.toString(d * d);
				if (s1.charAt(s1.length() - 1) == '0' && s1.charAt(s1.length() - 2) == '.')
					s1 = s1.substring(0, s1.length() - 2);
				lb.setText(s1);				
			} catch (Exception e1) { }
		}
}
	void cal(String s1) {
		if (s1.lastIndexOf("+") == s1.length() - 1 || s1.lastIndexOf("-") == s1.length() - 1 || s1.lastIndexOf(".") == s1.length() - 1
				|| s1.lastIndexOf("/") == s1.length() - 1 || s1.lastIndexOf("*") == s1.length() - 1 || s1 == "0" || check(s1))
				return ;
			double t = 0;
			int cnt = 0;
			String num[] = s1.split("\\+|\\-|\\*|\\/");
			String opp2 = s1.replaceAll("[0-9]", "");
			String opp = opp2.replaceAll("[.]", "");
			for (int i=0; i<opp.length(); i++)
			{
				char c = opp.charAt(i);
				if (c == '*' || c == '/')
				{
					if (c == '*')
						t = Double.parseDouble(num[i]) * Double.parseDouble(num[i + 1]);
					else
						t = Double.parseDouble(num[i]) / Double.parseDouble(num[i + 1]);	
					num[i] = num[i + 1] = Double.toString(t);
					for (int k=0; k<cnt; k++)
						num[i - k - 1] = num[i];
					cnt++;
				} else
					cnt = 0;
			}
			cnt = 0;
			for (int i=0; i<opp.length(); i++)
			{
				char c = opp.charAt(i);
				if (c == '+' || c == '-')
				{
					if (c == '+')
					{
						if (cnt == 0)
							t = Double.parseDouble(num[i]) + Double.parseDouble(num[i + 1]);							
						else
							t += Double.parseDouble(num[i + 1]);
					}
					else
					{
						if (cnt == 0)
							t = Double.parseDouble(num[i]) - Double.parseDouble(num[i + 1]);							
						else
							t -= Double.parseDouble(num[i + 1]);
					}
					num[i] = num[i + 1] = Double.toString(t);
				}
				cnt++;
			}
			if ('.' == num[num.length - 1].charAt(num[num.length - 1].length() - 2) && ('0' == num[num.length - 1].charAt(num[num.length - 1].length() - 1)))
				num[num.length - 1] = num[num.length - 1].substring(0, num[num.length - 1].length() - 2);
			lb.setText(num[num.length - 1]);
	}
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		C2017104138 c;
		c = new C2017104138();
	}
}
