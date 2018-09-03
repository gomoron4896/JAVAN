package test;

public class LoopTest {

	public static void main(String[] args) {
		Long sTime = System.currentTimeMillis();
		for(int i=1;i<=10000;i++) {
			System.out.println(i + "번째 작업");
		}
		System.out.println("총 작업시간 : " + (System.currentTimeMillis()-sTime));

		sTime = System.currentTimeMillis();
		for(int i=1;i<=10000;i++) {
		}
		System.out.println("총 작업시간 : " + (System.currentTimeMillis()-sTime));
		
	}
}
