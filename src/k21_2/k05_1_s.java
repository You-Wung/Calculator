package k21_2;

import java.io.File;
import java.util.*;

public class k05_1_s {
//	${string_prompt}
	public static void main(String[] args) {
		System.out.println("File 클래스 메소드 사용");
		if (args.length != 1)
		{
			System.err.println("args.length : " + args.length);
			System.exit(-1);
		} else {
			System.out.println("파일명 : " + args[0]);
		}
		File f1 = new File(args[0]);
		if (f1.exists()) {
			System.out.println("파일이 존재");
			info(f1);
			components(f1);
		} else {
			System.err.println(f1.getPath() + " 없음");
		}
	}

	static void components(File f) {
		String[] flist;
		flist = f.list();
		for (int i=0; flist != null && i<flist.length; i++) {//시험4번문제
			File subf = new File(flist[i]);
			stat(subf);
		}
	}
	//static 누구든 접근가능한 (시험3번 문제, 파라미터 자료형)
	static void info(File f) {
		System.out.println("파일 경로: " + f.getParent());
		stat(f);
	}
	static void stat(File f) {
		System.out.println("파밀명: " + f.getName());
		System.out.println("용량: " + f.length() + "byte");
		Date d= new Date(f.lastModified());
		System.out.println("수정일: " + d);
	}
}
