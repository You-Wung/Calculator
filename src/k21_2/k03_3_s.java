// try catch finally sample
package k21_2;
public class k03_3_s {
	public static void main(String[] args) {
		int a, b, d;
		a = 10;
		b = 0;
		d = 0;
		String a1 = "aaa";
		//���� finally catch
		System.out.println("d: " + d);
		try {
			System.out.println("0���� ������ ��");
			a = b * b * b / b;
//			Integer.parseInt(a1);
			System.out.println("0���� ������ ��");
		} catch (NumberFormatException e) {
			System.out.println("�ѹ�����");
		} catch (ArithmeticException e) {
			System.out.println("������ ����: " + e);//������ ���� ����ó��
		} catch (Exception e) {
			System.out.println("�Ϲ��� ����: " + e);//�� ĳġ ���� �� �Ʒ� ����ȵ� ����1��
		} finally {
			System.out.println("###############fianlly: d: " + a);//������ ����(ĳġ ��Ƶ�)
		}
		System.out.println("Finish");
	}
}
