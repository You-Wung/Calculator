package k21_2;

import java.io.File;

import javax.swing.*;
import java.awt.*;


public class k05_2 extends JFrame {

	//Ŭ���� 3�������
	//����
	JFrame j;
	FileDialog fd;
	File[] f;
	//������
	//Ŭ������ ���� �̸�(�޼ҵ�ó�� ����)
	k05_2(){ 
		j = new JFrame();
		fd = new FileDialog(this);
		
		fd.setSize(500, 400);
		fd.setVisible(true);
		f = fd.getFiles();
		System.out.println("f[0]: " + f[0].getName());
		System.out.println("f[0]: " + f[0].length() + "byte");
	}
	//�޼ҵ�
	public static void main(String[] args) {
		k05_2 k1 = new k05_2();
		
	}

}
