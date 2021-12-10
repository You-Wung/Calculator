package k21_2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

@SuppressWarnings("serial")
public class C2017104139_backup2 extends JFrame implements ActionListener {
	JFrame			j;
	String			st[] = {"1", "2", "3", "+",
							"4", "5", "6", "-",
							"7", "8", "9", "/",
							"C", "0", ".", "x" };
	JButton			bt[] = new JButton[st.length];
	JButton			cal, bs;
	JLabel			lb;//출력
	JMenuBar		bar;
	JMenu			menu[] = new JMenu[3];
	JMenuItem		i[] = new JMenuItem[8];
	JRadioButton	ra1, ra2;//buttongroup이용해야지 하나만 선택가능
	ButtonGroup		gp1;//동시선택 불가
	JPanel			panel00;
	C2017104139_backup2()  {
		//button
		cal = new JButton("Calculate");
		cal.setBounds(0, 130, 350, 60);
		cal.setBackground(Color.black);
		cal.setFont(new Font("Terminal", Font.BOLD, 20));
		cal.setForeground(new Color(255, 255, 255));
		cal.addActionListener(this);
		//radio
		ra1 = new JRadioButton("Drak");
		ra2 = new JRadioButton("White");
	
		ra1.setBounds(30, 12, 70, 30);
		ra2.setBounds(145, 12, 70, 30);
		ra1.setBackground(Color.white);
		ra2.setBackground(Color.white);
		ra1.addActionListener(this);
		ra2.addActionListener(this);

		gp1 = new ButtonGroup();
		gp1.add(ra1);
		gp1.add(ra2);

		//menu
		bar = new JMenuBar();
		menu[0] = new JMenu("file");
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
	    
//		 UIManager.put("control", new Color(128, 128, 128));
//		    UIManager.put("info", new Color(128, 128, 128));
//		    UIManager.put("nimbusBase", new Color(18, 30, 49));
//		    UIManager.put("nimbusAlertYellow", new Color(248, 187, 0));
//		    UIManager.put("nimbusDisabledText", new Color(128, 128, 128));
//		    UIManager.put("nimbusFocus", new Color(115, 164, 209));
//		    UIManager.put("nimbusGreen", new Color(176, 179, 50));
//		    UIManager.put("nimbusInfoBlue", new Color(66, 139, 221));
//		    UIManager.put("nimbusLightBackground", new Color(18, 30, 49));
//		 SwingUtilities.updateComponentTreeUI(this);
		 for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			    if ("control".equals(info.getName())) {
			        try {
						UIManager.setLookAndFeel(info.getClassName());
					} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
							| UnsupportedLookAndFeelException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        break;
			    }
			}
	
		j = new JFrame("C_2017104138");
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
		//add
		j.add(cal);
		j.add(panel00);
		j.setJMenuBar(bar);
		j.add(ra1);
		j.add(ra2);
		j.add(lb);
		j.add(bs);
		j.setVisible(true);
	}
	
	public void set_jbutton() {
		for(int i=0; i<bt.length; i++) {
			bt[i] = new JButton(st[i]);
			bt[i].addActionListener(this);
			bt[i].setBackground(Color.black);
			bt[i].setForeground(new Color(255, 255, 255));
			bt[i].setFont(new Font("Terminal", Font.BOLD, 20));
			panel00.add(bt[i]);
		}
		bs = new JButton("BackSpace");
		bs.setForeground(Color.white);
		bs.setBounds(240, 9, 100, 40);
		bs.setBackground(Color.black);
		bs.addActionListener(this);
	}
	public boolean last_is_num(String s)
	{
		char buf = s.charAt(s.length() - 1);
		int i  = buf - '0';
		if (i >= 0 && i <= 9)
			return (true);
		return (false);
	}
	public boolean check(String s)
	{
		for(int i=0; i<s.length(); i++)
		{
			if (s.charAt(i) == 'v' || s.charAt(i) == 'c' || s == "2017104138")
				return (true);
		}
		return (false);
	}
	public void actionPerformed(ActionEvent e) {
		String s1;
		
		s1 = lb.getText();
		if(e.getSource() == bt[12]) {
			lb.setText("0");
		}else if (e.getSource() == i[0]) {
			lb.setText("cheerup");
		}else if (e.getSource() == i[1]) {
			System.exit(0);
		}else if (e.getSource() == i[2]) {
			lb.setText("v1.0");
		}else if (e.getSource() == i[3]) {
			lb.setText("2017104138");
		}else if (e.getSource() == i[4]) {
			for(int i=0; i<bt.length; i++) {
				bt[i].setBackground(Color.black);
				bt[i].setForeground(new Color(255, 255, 255));
			}
			cal.setBackground(Color.black);
			cal.setForeground(new Color(255, 255, 255));
		}else if (e.getSource() == i[5]) {
			for(int i=0; i<bt.length; i++) {
				bt[i].setBackground(Color.white);
				bt[i].setForeground(new Color(0, 0, 0));
			}
			cal.setBackground(Color.white);
			cal.setForeground(new Color(0, 0, 0));
		}else if (e.getSource() == ra1) {
			lb.setBackground(Color.black);
			lb.setForeground(Color.white);
		}else if (e.getSource() == ra2) {
			lb.setBackground(Color.white);
			lb.setForeground(Color.black);
		}else if (e.getSource() == bs) {
			if (s1.length() > 0)
			{
				s1 = s1.substring(0, s1.length() - 1);
				System.out.println(s1);
				lb.setText(s1);
			}
		}else if (e.getSource() == bt[0] || e.getSource() == bt[1] || e.getSource() == bt[2] || e.getSource() == bt[4]
				 || e.getSource() == bt[5] || e.getSource() == bt[6] || e.getSource() == bt[8]  || e.getSource() == bt[9]
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
			if (s1.charAt(s1.length() - 1) == '.' || i == 0)
				return ;
			if (i >= j)
				lb.setText(s1 + ".");
		} else if (e.getSource() == cal) {
			if (s1.lastIndexOf("+") == s1.length() - 1 || s1.lastIndexOf("-") == s1.length() - 1 || s1.lastIndexOf(".") == s1.length() - 1
				|| s1.lastIndexOf("/") == s1.length() - 1 || s1.lastIndexOf("*") == s1.length() - 1 || s1 == "0" || check(s1))
				return ;
			double t;
			int cnt = 0;
			String num[] = s1.split("\\+|\\-|\\*|\\/"); 
			String opp2 = s1.replaceAll("[0-9]", "");
			String opp = opp2.replaceAll("[.]", "");
			
			for (int i=0; i<opp.length(); i++)
			{
				char c = opp.charAt(i);
				if (c == '*')
				{
					t = Double.parseDouble(num[i]) * Double.parseDouble(num[i + 1]);
					num[i] = num[i + 1] = Double.toString(t);
					for (int k=0; k<cnt; k++)
						num[i - k - 1] = num[i];
					cnt++;
				}
			}
			for (int i=0; i<opp.length(); i++)
			{
				char c = opp.charAt(i);
				if (c == '/')
				{
					t = Double.parseDouble(num[i]) / Double.parseDouble(num[i + 1]);
					num[i] = num[i + 1] = Double.toString(t);
				}
			}
			for (int i=0; i<opp.length(); i++)
			{
				char c = opp.charAt(i);
				if (c == '+')
				{
					t = Double.parseDouble(num[i]) + Double.parseDouble(num[i + 1]);
					num[i] = num[i + 1] = Double.toString(t);
				}
			}
			for (int i=0; i<opp.length(); i++)
			{
				char c = opp.charAt(i);
				if (c == '-')
				{
					t = Double.parseDouble(num[i]) - Double.parseDouble(num[i + 1]);
					num[i] = num[i + 1] = Double.toString(t);
				}
			}
			
			if ('.' == num[num.length - 1].charAt(num[num.length - 1].length() - 2) && ('0' == num[num.length - 1].charAt(num[num.length - 1].length() - 1)))
				num[num.length - 1] = num[num.length - 1].substring(0, num[num.length - 1].length() - 2);
				
			lb.setText(num[num.length - 1]);
		}
}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		C2017104139_backup2 c;
		c = new C2017104139_backup2();
	}

}
