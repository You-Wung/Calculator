package k21_2;

import java.io.File;
import java.util.*;

public class k05_1_s {
//	${string_prompt}
	public static void main(String[] args) {
		System.out.println("File Ŭ���� �޼ҵ� ���");
		if (args.length != 1)
		{
			System.err.println("args.length : " + args.length);
			System.exit(-1);
		} else {
			System.out.println("���ϸ� : " + args[0]);
		}
		File f1 = new File(args[0]);
		if (f1.exists()) {
			System.out.println("������ ����");
			info(f1);
			components(f1);
		} else {
			System.err.println(f1.getPath() + " ����");
		}
	}

	static void components(File f) {
		String[] flist;
		flist = f.list();
		for (int i=0; flist != null && i<flist.length; i++) {//����4������
			File subf = new File(flist[i]);
			stat(subf);
		}
	}
	//static ������ ���ٰ����� (����3�� ����, �Ķ���� �ڷ���)
	static void info(File f) {
		System.out.println("���� ���: " + f.getParent());
		stat(f);
	}
	static void stat(File f) {
		System.out.println("�Ĺи�: " + f.getName());
		System.out.println("�뷮: " + f.length() + "byte");
		Date d= new Date(f.lastModified());
		System.out.println("������: " + d);
	}
}
