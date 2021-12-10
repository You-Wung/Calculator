// try catch finally sample
package k21_2;
public class k03_3_s {
	public static void main(String[] args) {
		int a, b, d;
		a = 10;
		b = 0;
		d = 0;
		String a1 = "aaa";
		//시험 finally catch
		System.out.println("d: " + d);
		try {
			System.out.println("0으로 나누기 전");
			a = b * b * b / b;
//			Integer.parseInt(a1);
			System.out.println("0으로 나누기 후");
		} catch (NumberFormatException e) {
			System.out.println("넘버포멧");
		} catch (ArithmeticException e) {
			System.out.println("수학적 예외: " + e);//수학적 연산 예외처리
		} catch (Exception e) {
			System.out.println("일반적 예외: " + e);//위 캐치 성공 시 아래 실행안됨 시험1번
		} finally {
			System.out.println("###############fianlly: d: " + a);//무조건 실행(캐치 잡아도)
		}
		System.out.println("Finish");
	}
}
