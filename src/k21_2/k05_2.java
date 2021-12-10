package k21_2;

import java.io.File;

import javax.swing.*;
import java.awt.*;


public class k05_2 extends JFrame {

	//클래스 3구성요소
	//변수
	JFrame j;
	FileDialog fd;
	File[] f;
	//생성자
	//클래스와 같은 이름(메소드처럼 생김)
	k05_2(){ 
		j = new JFrame();
		fd = new FileDialog(this);
		
		fd.setSize(500, 400);
		fd.setVisible(true);
		f = fd.getFiles();
		System.out.println("f[0]: " + f[0].getName());
		System.out.println("f[0]: " + f[0].length() + "byte");
	}
	//메소드
	public static void main(String[] args) {
		k05_2 k1 = new k05_2();
		
	}

}
